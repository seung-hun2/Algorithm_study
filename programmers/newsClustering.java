package programmers;
import java.util.ArrayList;
import java.util.List;

public class newsClustering {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for(int i=0;i<str1.length()-1;i++){
            for(int j=i;j<i+1;j++){
                if(str1.charAt(j) >= 'a' && str1.charAt(j)<= 'z'){
                    if(str1.charAt(j+1) >= 'a' && str1.charAt(j+1)<= 'z'){
                        list1.add(str1.charAt(j) + String.valueOf(str1.charAt(j+1)));
                    }
                }
            }
        }
        for(int i=0;i<str2.length()-1;i++){
            for(int j=i;j<i+1;j++){
                if(str2.charAt(j) >= 'a' && str2.charAt(j)<= 'z'){
                    if(str2.charAt(j+1) >= 'a' && str2.charAt(j+1)<= 'z'){
                        list2.add(str2.charAt(j) + String.valueOf(str2.charAt(j+1)));
                    }
                }
            }
        }
        int inter=0;
        if(list2.size()<list1.size()) {
            for (int i = 0; i < list2.size(); i++) {
                if (list1.contains(list2.get(i))) {
                    inter++;
                    list1.remove(list2.get(i));
                }
            }
        }else{
            for (int i = 0; i < list1.size(); i++) {
                if (list2.contains(list1.get(i))) {
                    inter++;
                    list2.remove(list1.get(i));
                }
            }
        }
        double ans=0;

        if(list1.size() == 0 && list2.size() == 0){
            ans = 1;
        }else{
            ans = (double)inter/(list1.size()+list2.size());
        }
        answer = (int)(ans * 65536);
        return answer;
    }
}
