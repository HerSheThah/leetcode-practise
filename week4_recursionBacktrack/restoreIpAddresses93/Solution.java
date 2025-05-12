package week4_recursionBacktrack.restoreIpAddresses93;

import java.util.ArrayList;
import java.util.List;
//93. Restore IP Addresses
//        Solved
//        Medium
//        Topics
//        Companies
//        A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
//
//        For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
//        Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
//
//
//
//        Example 1:
//
//        Input: s = "25525511135"
//        Output: ["255.255.11.135","255.255.111.35"]
//        Example 2:
//
//        Input: s = "0000"
//        Output: ["0.0.0.0"]
//        Example 3:
//
//        Input: s = "101023"
//        Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
//
//
//        Constraints:
//
//        1 <= s.length <= 20
//        s consists of digits only.

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ips= new ArrayList<>();
        String ip="";
        backTrack(0, 0, ip, ips, s, s.length());
        return ips;
    }

    private static void backTrack(int index, int dot, String ip, List<String> ips, String s, int n){

        if(dot==3){
            String subs= s.substring(index);
            if(isvalid(subs)){
                ip+=subs;
                ips.add(ip);
            }
            return;
        }

        for(int i=index; i<n;i++){
            System.out.println("ip: "+ ip);
            String subs= s.substring(index, i+1);
            if(isvalid(subs)){
                ip+= subs+".";
                dot++;
                backTrack(i+1, dot, ip, ips, s, n);
                dot--;
                ip=ip.substring(0, ip.length()-subs.length()-1);
            }
        }

    }

    private static boolean isvalid  (String st){
        if(st.length()<=0 || st.length()>3 || (st.length()>1 && st.charAt(0)=='0')
                || Integer.valueOf(st)>255)
            return false;
        return true;
    }
}