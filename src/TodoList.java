import java.util.ArrayList;

public class TodoList {
       private ArrayList<String> todoList = new ArrayList<>();
       private String komList = "LIST".intern();
       private String komAdd = "ADD".intern();
       private String komEdit = "EDIT".intern();
       private String komDelete = "DELETE".intern();
       private String regex = "[0-9]+";


       public void text(String textTodo) {
           String[] words = textTodo.split("\\s+");
           String kom = words[0].intern();

           if (kom != komAdd && kom != komList && kom != komDelete && kom != komEdit) {
               System.out.println("Нет такой команды");
               return;
           }

           if (kom == komList) {
               printList(todoList);
               return;
           }

           if (words.length <= 1) {
               System.out.println("Вы не ввели текст");
               return;
           }

           if (!words[1].matches(regex)) {
               if (kom == komAdd) {
                   addList(newText(words, 1));
                   System.out.println("Добавлено дело \"" + newText(words, 1) + "\"");
               } else {
                   System.out.println("Нет команды ADD");
               }
           } else {
               int komIndex = Integer.parseInt(words[1]);
               if (kom == komAdd) {
                   if (komIndex < todoList.size()) {
                   addList(komIndex, newText(words, 2));
                       System.out.println("Добавлено дело \"" + newText(words, 2) + "\"");
               } else {
                       addList(newText(words, 2));
                       System.out.println("Добавлено дело \"" + newText(words, 2) + "\"");
                   }
               } else if (kom == komEdit) {
                   if (komIndex < todoList.size()) {
                       System.out.println("Дело \"" + todoList.get(komIndex) + "\" заменено на \"" + newText(words, 2) + "\"");
                       setList(komIndex, newText(words, 2));
                   } else {
                       System.out.println("Дело с таким номером не существует");
                   }
               } else if (kom == komDelete) {
                   if (komIndex < todoList.size()) {
                       System.out.println("Дело \"" + todoList.get(komIndex) + "\" удалено");
                       deleteList(komIndex);
                   } else {
                       System.out.println("Дело с таким номером не существует");
                   }
               } else {
                   System.out.println("Что то не так с параметром или командой (ADD;EDIT;DELETE)");
               }
           }
       }

           private void addList(String text) {
                todoList.add(text);
           }
           private void addList(int index, String text) {
                todoList.add(index, text);
             }

           private void setList(int index, String text) {
                todoList.set(index, text);
           }

           private void deleteList(int index) {
                todoList.remove(index);
           }

           private String newText(String[] words, int index) {
               String newText = "";
               for (int i = index; i < words.length; i++) {
                       newText += words[i] + " ";
                   }
               return newText;
           }


       private void printList(ArrayList<String> todoList) {
            //int caseNumber = 1;
            if (todoList.size() != 0) {
                for (int i = 0; i < todoList.size(); i++) {
                    System.out.println(i + " - " + todoList.get(i));
                }
            } else {
                System.out.println("Список дел пуст");
            }

       }


}
