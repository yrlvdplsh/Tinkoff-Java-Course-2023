package edu.hw3.task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class ContactParser {

    private ContactParser() {
    }

    public static List<String> parseContacts(List<String> contacts, String type) {
        if (contacts == null || contacts.isEmpty()) {
            return Collections.emptyList();
        }

        TreeSet<String> sortedContacts = new TreeSet<>(ContactParser::compare);
        sortedContacts.addAll(contacts);

        List<String> result = new ArrayList<>(sortedContacts.stream().toList());
        if (type.equals("ASC")) {
            return result;
        } else if (type.equals("DESC")) {
            Collections.reverse(result);
            return result;
        } else {
            throw new IllegalArgumentException("unsupported type of sorting!");
        }
    }

    private static int compare(String contact1, String contact2) {
        String[] parsedContact1 = contact1.split(" ");
        String[] parsedContact2 = contact2.split(" ");

        String comparableContact1 = parsedContact1.length > 1 ? parsedContact1[1] : parsedContact1[0];
        String comparableContact2 = parsedContact2.length > 1 ? parsedContact2[1] : parsedContact2[0];

        return comparableContact1.compareTo(comparableContact2);
    }
}
