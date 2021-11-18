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
                if(line.contains((CharSequence) iterator.next()))  { //если в комменте содержится слово из бан-листа
                    String newString = "";
                    line = line.trim();
                    String[] s = line.split("[ ,.?!:;]"); //разделим коммент на слова

                    for (String str : s) //переберем кажое слово из строки, где есть точно есть слово из бан-листа
                        if (str != "" && !str.isEmpty()){
                            if(str != iterator.next()) newString += str; //"удаляем" слова из бан-листа
                        }
                    newComments.add(newString); //добавляем чистые строки в новый (очищенный) список
                }
            }
        }

        comments.clear(); //очищаем старый список
        comments = newComments; //теперь в старом списке лежит очищенный список
    }
}

/*
добавила проверку на содержание подстроки со словом из бан-листа,
чтобы экономить время и пропускать строчки, в которых точно
нет слова из бан-листа

но О(н*м*к), где н - кол-во строк (элементы comments)
                 м - кол-во бан-слов (элементы множества blacklist)
                 k - кол-во слов в строке
тоже так себе сложность
 */