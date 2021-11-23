import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BlackList implements BlackListFilter{
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        Iterator iterator = blackList.iterator();
        List<String> newComments = new ArrayList<>();

        for (int i = 0; i < comments.size(); ++i) { //пройдемся по каждому комменту
            String line = comments.get(i);
            while (iterator.hasNext()) { //переберем множество слов в бан-листе
                if(!line.contains((CharSequence) iterator.next()))  { //если в комменте не содержится слово из бан-листа
                    newComments.add(line); //добавляем только те комменты, где нет слов их бан-листа
                    //еще можно не заводить newComments, а делать comments.remove(i);
                }
            }
        }

        comments.clear(); //очищаем старый список
        comments = newComments; //теперь в старом списке лежит очищенный список
    }
}