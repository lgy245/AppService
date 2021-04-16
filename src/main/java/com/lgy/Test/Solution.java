package com.lgy.Test;

import java.util.*;

/*
 *@autor lgy
 *
 *@date 2021/3/23 14:31
 ****/
public class Solution {
   /* public static void main(String[] args) {
        String [] aa  = {"eat", "tea", "tan", "ate", "nat", "bat"};
        int [] bb  = {1,2,8,4};
        int target =5;
        String math ="math";
        System.out.println(new String(math.getBytes()));
        //System.out.println((-116546*10)+(-116546%10));
        //System.out.println(Arrays.toString(twoSum(bb,target)) );
        //System.out.println(Arrays.toString(twoSumtwo(bb,target)) );
        //System.out.println(reverse(-153423469));
        //System.out.println(two(11211));
        //System.out.println(tworeverse(20));head = [1,2,3,3,4,4,5]
        //System.out.println(deleteDuplicates(cc));
        //isPalindrome(121);
        //forS(aa);
        boolean b = false;
        for (int i =0;i<4&&!b;i++){
            System.out.println(i+"i");
            for (int a = 0 ;a<4;a++){
                if(a==1){
                    System.out.println(a+"a");
                    b=true;
                    break;
                }
            }
        }
    }
*/
        public static List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, ArrayList<String>> map=new HashMap<>();
            for(String s:strs){
                char[] ch=s.toCharArray();
                Arrays.sort(ch);
                String key=String.valueOf(ch);

                if(!map.containsKey(key))    map.put(key,new ArrayList<>());
                map.get(key).add(s);
            }
            return new ArrayList(map.values());
        }

        public static void forS(String [] strs){
            Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
           // System.out.println(Arrays.toString(strs));
            for(String s:strs){
              //  System.out.println(s);
                char [] h = s.toCharArray();
                Arrays.sort(h);
                String key=String.valueOf(h);
                System.out.println(key);
                if(!map.containsKey(key)){
                    map.put(key,new ArrayList<>());
                }
                    map.get(key).add(s);

            }
            System.out.println(map.values());
        }
        public static int[] twoSum(int[] nums, int target) {
            int [] numbers = new int[2];

            for(int i=0;i<nums.length;i++){
                int suma = nums[i];
                for(int s = 0; s<nums.length;s++){
                    int sumb = nums[s];
                    if(suma + sumb == target){
                        numbers[0] = i;
                        numbers[1] = s;
                        break;
                    }
                }
            }
                return numbers;
        }
    public static int[] twoSumtwo(int[] nums, int target) {
        int [] numbers = new int[2];
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                numbers[0] = i;
                numbers[1] = hash.get(nums[i]);
                break;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);

        }
        return numbers;
    }
    public static int reverse(int x) {
        StringBuffer stringBuffer = new StringBuffer();
            int a = 0;
            int b = 0;
        String str =String.valueOf(x);
            try {
                if(x<0){
                    b=-1;
                    str=str.substring(1);
                }else if(x==0){
                    b=0;
                }else{
                    b=1;
                }
                stringBuffer.append( new StringBuffer(str).reverse()) ;
                a=Integer.valueOf(stringBuffer.toString())*b;
            }catch (Exception e){
                return 0;
            }

        return a;
    }
    public static boolean isPalindrome(int x) {
        boolean a =false;
        String before =String.valueOf(x);
        String after =String.valueOf(new StringBuffer(String.valueOf(x)).reverse());
        if(after.equals(before)){
            a=true;
        }

        return a;
    }

    public static boolean two(int x) {
        int reversed=0;//10
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;

            x /= 10;
        }
        System.out.println(reversed);
        System.out.println(x);
        return x==reversed||x==reversed/10;
    }
    public static boolean tworeverse (int x) {
        String b = String.valueOf(x);
        int length = b.length();
        String reverse = "";//新建空字符串
        for (int i = 0; i < length; i++) {
            reverse = b.charAt(i) + reverse;//在新字符串前面添加读取字符，实现翻转
        }
        return b.equals(reverse);
    }
    public static int aa (int n) {
        if(n==1){
            return n;
        }
        return n+aa(n-1);
    }
    public  static int defor(int n){
        int sumV = 1;
        for (int i = 0;i<n;i++){
            sumV *= (n-i);
        }
        return sumV;
    }

    public  static  int def(int n){
            if(n==1){
                return n;
            }
            return  n*def(n-1);
    }
    // 5*4*3*2*1
    public static List<String> getList(List<String> list){
        for (String item : list) {
            if ("1".equals(item)) {
                list.remove(item);
            }
        }
            return list;
    }


     }
