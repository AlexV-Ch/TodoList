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
               return;
           }

           if (kom == komList) {
               printList(todoList);
               return;
           }

           if (words.length <= 1) {
               return;
           }

           if (!words[1].matches(regex)) {
               if (kom == komAdd) {
                   addList(textTodo);
               } else {
                   System.out.println("Нет команды Add");
               }
           } else {
               int komIndex = Integer.parseInt(words[1]) - 1;
               if (kom == komAdd) {
                   if (komIndex <= todoList.size()) {
                   addList(komIndex, textTodo);
               } else {
                       addList(textTodo);
                   }
               } else if (kom == komEdit) {
                   if (komIndex <= todoList.size()) {
                       setList(komIndex, textTodo);
                   }
               } else if (kom == komDelete) {
                   if (komIndex <= todoList.size()) {
                       deleteList(komIndex);
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


       private void printList(ArrayList<String> todoList) {
            int caseNumber = 1;
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println(caseNumber++ + " - " + todoList.get(i));
            }
       }


}
