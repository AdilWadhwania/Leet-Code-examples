package com.leet.code.roman.to.integer;

import java.util.HashMap;

public class RomanToInteger
{
    /* Variable is used to store roman character and value mapping
       It is initialized while creating object
    * */
    private final HashMap<Character,Integer> romanToValMapping;

    public RomanToInteger()
    {
        this.romanToValMapping = romanTovalMapping();
    }

    /**
     * Main method to find the actual integer value of given roman number
     * @param s The string s is the input roman numbers string
     * @return the actual value of roman representation or -1 if the input is invalid
     */
    public int romanToInt(String s)
    {
        int output;

        char[] char_array=s.toCharArray();
        output=getValueOfRoman(char_array);
        return output;
    }

    public int getValueOfRoman(char[] char_array)
    {
        int output=0;
        for (int i=0;i<char_array.length;i++)
        {
            char current_char = char_array[i];
            if(i!=char_array.length-1)
            {
                char next_char = char_array[i + 1];
                if (romanToValMapping.containsKey(current_char) && romanToValMapping.containsKey(next_char))
                {
                    int current_charLen = getLengthOfRomanChar(romanToValMapping.get(current_char));
                    int next_charLen = getLengthOfRomanChar(romanToValMapping.get(next_char));

                    int current_charValue = romanToValMapping.get(current_char);
                    int next_charValue = romanToValMapping.get(next_char);

                    if (current_charLen > next_charLen)
                    {
                        output += valueOfRomanPair(current_charValue, 0);
                    }
                    else
                    {
                        output += valueOfRomanPair(current_charValue, next_charValue);
                        i++;
                    }
                }
                else
                {
                    System.out.println("Invalid Input");
                    output = -1;
                    break;
                }
            }
            else
            {
                if(romanToValMapping.containsKey(current_char))
                {
                    output += valueOfRomanPair(romanToValMapping.get(current_char),0);
                }
            }
        }
        return output;
    }

    private int valueOfRomanPair(int current,int next)
    {
        if(current>next)
        {
            return current+next;
        }
        else if(current<next)
        {
            return next-current;
        }
        else
        {
            return  current+next;
        }

    }

    private int getLengthOfRomanChar(int characterValue)
    {
        return String.valueOf(characterValue).length();
    }

    /**
     * Creates an hashmap of roman character to its value representation
     * @return the hashmap of roman character to Integer value mapping
     */
    private static HashMap<Character,Integer> romanTovalMapping()
    {
        HashMap<Character,Integer> romanToValMapping=new HashMap<>();
        romanToValMapping.put('I',1);
        romanToValMapping.put('V',5);
        romanToValMapping.put('X',10);
        romanToValMapping.put('L',50);
        romanToValMapping.put('C',100);
        romanToValMapping.put('D',500);
        romanToValMapping.put('M',1000);
        return romanToValMapping;
    }
}
