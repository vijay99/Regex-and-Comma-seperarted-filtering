package com.vijay;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author Kumar Vijay
 */
public class RegexFilter {
    public static void main(String[] args) {
        //Comma separated String act as input for filtering matched string
        String commaSepString = "QA Team 7,QATeam 10,Team13,Test Team,Team1,Team2,Team3,Team4,Team5,Team6'),qwertyuiopasdfghjklzxcvbnm12345678qwertyui23456,!@#$%^&$%^&*()+-:,2345678901234567890123456789012345678901234567890qwertyuiopqwertyuiopqwertyuiopqwertyu,2345678901234567890123456789012345678901234567890qwertyuiopqwertyuiopqwertyuiopqwertyu789685298653287542,SACUMEN,SACUMen,null,123456789,sacumen                         team,Team_Special_Characters";
        List<String> allStringList = Arrays.asList(commaSepString.split(","));
        //Filtered String List with matching regex pattern
        List<String> filterStringList = getFilteredStringOnly(allStringList);
        System.out.print("\nMatching Strings are:" + filterStringList);
    }


    private static List<String> getFilteredStringOnly(List<String> allStringList) {
        List<String> filteredStringList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the Regex pattern to filter string:");
        String regexFilter = sc.nextLine();

        Pattern patternIncludes = null;
        try {
            patternIncludes = Pattern.compile(regexFilter);
        } catch (PatternSyntaxException patternSyntaxException) {
            patternSyntaxException.printStackTrace();
        }


        if (Objects.nonNull(patternIncludes)) {
            for (String str : allStringList) {
                if (patternIncludes.matcher(str).find()) {
                    filteredStringList.add(str);
                }
            }

        }
        return filteredStringList;
    }
}
