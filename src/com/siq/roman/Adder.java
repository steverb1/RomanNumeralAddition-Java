package com.siq.roman;

import java.util.*;

public class Adder
{
    private HashMap<String, String> subtractives = new HashMap<>();
    private HashMap<String, String> equivalents = new HashMap<>();

    public Adder()
    {
        subtractives.put("IV", "IIII");
        subtractives.put("IX", "VIIII");
        subtractives.put("XL", "XXXX");
        subtractives.put("XC", "LXXXX");
        subtractives.put("CD", "CCCC");
        subtractives.put("CM", "DCCCC");

        equivalents.put("IIIII", "V");
        equivalents.put("VV", "X");
        equivalents.put("XXXXX", "L");
        equivalents.put("LL", "C");
        equivalents.put("CCCCC", "D");
        equivalents.put("DD", "M");
    }

    public String add(String input1, String input2)
    {
        input1 = uncompact(input1);
        input2 = uncompact(input2);

        ResultList resultList = new ResultList(input1, input2);

        sort(resultList);

        String result = replaceEquivalents(resultList.toString());

        result = compact(result);

        return result;
    }

    private String compact(String result)
    {
        for (Map.Entry<String, String> entry : subtractives.entrySet())
        {
            if (result.contains(entry.getValue()))
            {
                result = result.replaceAll(entry.getValue(), entry.getKey());
            }
        }

        return result;
    }

    private String replaceEquivalents(String result)
    {
        boolean equivalentsAllReplaced = false;

        while (!equivalentsAllReplaced)
        {
            boolean equivalentsFound = false;
            for (String key : equivalents.keySet())
            {
                if (result.contains(key))
                {
                    result = result.replaceAll(key, equivalents.get(key));
                    equivalentsFound = true;
                }
            }

            if (!equivalentsFound)
            {
                equivalentsAllReplaced = true;
            }
            else
            {
                ResultList resultList = new ResultList(result, "");
                sort(resultList);
                result = resultList.toString();
            }
        }

        return result;
    }

    private String uncompact(String input)
    {
        for (String key : subtractives.keySet())
        {
            if (input.contains(key))
            {
                input = input.replaceAll(key, subtractives.get(key));
            }
        }

        return input;
    }

    private void sort(ResultList result)
    {
        Collections.sort(result, new RomanNumeralComparator());
    }
}

class RomanNumeralComparator implements Comparator<String>
{
    ArrayList<String> orderedSymbols = new ArrayList<>(Arrays.asList("I", "V", "X", "L", "C", "D", "M"));

    @Override
    public int compare(String value1, String value2)
    {
        int position1 = orderedSymbols.indexOf(value1);
        int position2 = orderedSymbols.indexOf(value2);

        return position1 < position2 ? 1 : position1 == position2 ? 0 : -1;
    }
}

class ResultList extends LinkedList<String>
{
    public ResultList(String input1, String input2)
    {
        for (int i = 0; i < input1.length(); i++)
        {
            add(String.valueOf(input1.charAt(i)));
        }

        for (int i = 0; i < input2.length(); i++)
        {
            add(String.valueOf(input2.charAt(i)));
        }
    }

    public String toString()
    {
        String result = "";
        Iterator<String> iterator = super.iterator();
        while (iterator.hasNext())
        {
            result += iterator.next();
        }

        return result;
    }
}
