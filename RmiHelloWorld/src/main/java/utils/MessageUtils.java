package utils;

import common.IMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MessageUtils {
    public static List<IMessage> intersect(List<IMessage> list1, List<IMessage> list2){
        return list1.stream().filter(mes -> !list2.contains(mes)).collect(Collectors.toList());
    }
}
