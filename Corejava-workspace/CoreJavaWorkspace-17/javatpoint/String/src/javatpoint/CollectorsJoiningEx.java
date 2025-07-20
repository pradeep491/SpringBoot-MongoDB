package javatpoint;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsJoiningEx {
public static void main(String[] args) {
	List<String> list = Arrays.asList("pradeep","kumar","kandyala");
	String str = list.stream().collect(Collectors.joining(", "));
	System.out.println(str);
}
}
