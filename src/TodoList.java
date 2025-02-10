import java.util.ArrayList;

public class TodoList {
       private final ArrayList<String> todoList = new ArrayList<>();
       private final String komList = "LIST";
       private final String komAdd = "ADD";
       private final String komEdit = "EDIT";
       private final String komDelete = "DELETE";
       private final String regex = "[0-9]+";


       public void text(String textTodo) {
           String[] words = textTodo.split("\\s+");
           String kom = words[0].intern();

           if (!kom.equals(komAdd) && !kom.equals(komList) && !kom.equals(komDelete) && !kom.equals(komEdit)) {
               System.out.println("Нет такой команды");
               return;
           }

           if (kom.equals(komList)) {
               printList(todoList);
               return;
           }

           if (words.length <= 1) {
               System.out.println("Вы не ввели текст");
               return;
           }

           if (!words[1].matches(regex)) {
               if (kom.equals(komAdd)) {
                   addList(newText(words, 1));
                   System.out.println("Добавлено дело \"" + newText(words, 1).trim() + "\"");
               } else {
                   System.out.println("Нет индекса у команды");
               }
           } else {
               int komIndex = Integer.parseInt(words[1]);
               if (kom.equals(komAdd)) {
                   if (komIndex < todoList.size()) {
                       addList(komIndex, newText(words, 2));
                       System.out.println("Добавлено дело \"" + newText(words, 2).trim() + "\"");
               } else {
                       addList(newText(words, 2));
                       System.out.println("Добавлено дело \"" + newText(words, 2).trim() + "\"");
                   }

               } else if (kom.equals(komEdit)) {
                   if (komIndex < todoList.size()) {
                       System.out.println("Дело \"" + todoList.get(komIndex).trim()
                               + "\" заменено на \"" + newText(words, 2).trim() + "\"");
                       setList(komIndex, newText(words, 2));
                   } else {
                       System.out.println("Дело с таким номером не существует");
                   }

               } else if (kom.equals(komDelete)) {
                   if (komIndex < todoList.size()) {
                       System.out.println("Дело \"" + todoList.get(komIndex).trim() + "\" удалено");
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
