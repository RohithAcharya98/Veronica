package HackerEarth;

import java.util.*;
import java.io.*;
//Occurance of Character in a String : 
//3.
/*
class Test{
	
	public static int result(char ch,String str){
		int count=0,value=0;
		for(int i=0;i<str.length();i++){
			if(ch==str.charAt(i)){count++;value=i;}
		}
		System.out.println(ch+" "+count);
		return value+1;
	}
	public static void main(String... args){
		String str="aaabbbccdddf";
		int j=0; char ch=' ';
		while(j<str.length()){
			ch=str.charAt(j);
			j=result(ch,str);
			//System.out.println(j);
		}
	}
}

//ccdddeeeef

/**/


/*
class Test{
	public static String result(char ch,String str){
		int count=0,value=0; StringBuffer sb=new StringBuffer();
		for(int i=0;i<str.length();i++){
			if(ch==str.charAt(i)){count++;}
			else{sb.append(str.charAt(i));}
		}
		System.out.println(ch+" "+count);
		//System.out.println(sb.toString());
		return sb.toString();
	}
	public static void main(String... args){
		String str="aaabaabbfcfccdeef";
		String j=" "; char ch=' '; ch=str.charAt(0);
		j=result(ch,str);
		while(j.length()>=1){
			ch=j.charAt(0);
			j=result(ch,j);
			//System.out.println(j);
		}		
	}
}
/**/

//3.https://www.hackerearth.com/problem/algorithm/hamming-sort-09045827/?source=list_view
/*
class Test{
    
	public static int hammingDistance(int x,int y){
		int ans=0,m=Math.max(x,y);
		while(m>0){
			int c1=x & 1; int c2=y & 1;
			if(c1!=c2)
				ans+=1;
			m= m>>1;
			x= x>>1;
			y= y>>1;
		}
		return ans;
	}
    public static void main(String... args)throws Exception{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(),temp=0;int dist=0,v=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str1=br.readLine();
		String[] strarr=str1.split(" ");
		int n=Integer.parseInt(strarr[0]); int k=Integer.parseInt(strarr[1]);
		List<Integer> l=new ArrayList<>();
		str1=br.readLine(); strarr=str1.split(" ");
		for(int i=0;i<n;i++){
			temp=Integer.parseInt(strarr[i]);
			l.add(temp);
		}List<Integer> li=new ArrayList<>(); List<Integer> l1=new ArrayList<>();
		for(int i=0;i<n;i++){
			dist=hammingDistance(l.get(i),k);
			li.add(dist);
		}Collections.sort(li);
		for(int i=0;i<n;i++){
			v=li.get(i);
			for(int j=0;j<n;j++){dist=hammingDistance(l.get(j),k);
			if(v==dist){temp=l.get(j);l1.add(temp);}}
		}
		System.out.println(l1);
    }
}
/**/


//4. https://www.hackerearth.com/problem/algorithm/cryptic-line-92a6bd09/?source=list_view
/*
class Test{
	public static int convert(String str){
		int n=Integer.parseInt(str);
		return n;
	}
	public static String result(List<Integer> l,int u, int v){
		String str="";
		for(int i=0;i<l.size();i++){
			if(i%2==0&&l.get(i)==u&&l.get(i+1)==v){str="YES";}
			//if(i%2==1&&l.get(i)==v){System.out.println("Value");}
		}
	
		if(str.equals("")){str="NO";}
		return str;
	}
	public static void main(String... args)throws Exception{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(); int c=sc.nextInt();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		List<Integer> l=new ArrayList<>(); StringBuffer sb=new StringBuffer();
		for(int i=0;i<n-1;i++){
			String str=br.readLine(); String[] strarr=str.split(" ");
			int u=convert(strarr[0]); int v=convert(strarr[1]);
			l.add(u);	l.add(v);
		}
		for(int i=0;i<c;i++){
			String str=br.readLine(); String[] strarr=str.split(" ");
			int u=convert(strarr[0]); int v=convert(strarr[1]);
			String st=result(l,u,v); sb.append(st); sb.append(" ");
		}
		System.out.println(sb);
	}
	
}
/**/


//https://www.hackerearth.com/problem/algorithm/signaling-07a313d7/?source=list_view
/*
class Test{
	public static void main(String... args)throws Exception{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt(); int n=sc.nextInt();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine(); int count=0;
		List<Integer> l=new ArrayList<>();
		List<Integer> re=new ArrayList<>();
		for(int i=0;i<n;i++){
			int temp=(int)str.charAt(i);
			if(temp==49){l.add(1);}
			else{l.add(0);}
		}
		for(int i=0;i<n;i++){
			if(l.get(i)==1){count++;}
			re.add(count);
			if(l.get(i)==0){count=0;}
		}Collections.sort(re); 
		System.out.println(re);
		System.out.println(re.get(re.size()-1));
	}
}

/*
1100111
1110011

/**/


//https://www.hackerearth.com/problem/algorithm/parity-binary-sort-ea768e57/?source=list_view
/*
class Test{
	public static int binary(int n){
		List<Integer> l=new ArrayList<>();
		int count=0;
		while(n>0){
			int temp=n%2;
			n=n/2; l.add(temp);
		}
		for(int i=0;i<l.size();i++){if(l.get(i)==1){count++;}}
		if(count%2==0){count=0;}else{count=1;}
		//System.out.println(count);
		return count;
	}
	public static void main(String... args)throws Exception{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt(); int n=sc.nextInt();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine(); String[] strarr=str.split(" ");
		List<Integer> l=new ArrayList<>();
		List<Integer> r1=new ArrayList<>(); List<Integer> r2=new ArrayList<>();
		for(int i=0;i<n;i++){
			int temp=Integer.parseInt(strarr[i]); l.add(temp);
		}
		for(int i=0;i<n;i++){
			int value=binary(l.get(i));
			if(value==1){r1.add(l.get(i));}else{r2.add(l.get(i));}
		}
		Collections.sort(r2); Collections.sort(r1);
		for(int i=0;i<r1.size();i++){r2.add(r1.get(i));}
		System.out.println(r2);
	}
	
}
/**/

//https://www.hackerearth.com/problem/algorithm/not-even-max-sum-a3ccf284/?source=list_view
/*
class Test{
	public static int result(List<Integer> l,int k){
		List<Integer> li=new ArrayList<>(); int temp=0;
		while(k>=0){
			temp=temp+l.get(k);
			k--;
		}
		return temp;
	}
	public static void main(String...  args)throws Exception{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt(); int n=sc.nextInt(),temp1=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine(); String[] strarr=str.split(" ");
		List<Integer> l=new ArrayList<>();  List<Integer> re=new ArrayList<>();
		for(int i=0;i<n;i++){
			int temp=Integer.parseInt(strarr[i]);
			l.add(temp);
		}
		for(int i=0;i<n;i++){temp1=result(l,i);re.add(temp1);}
		for(int i=n-1;i>=0;i--){if(re.get(i)%2==1){
			System.out.println(re.get(i));} break;}
		
	}
}
/**/

//https://www.hackerearth.com/problem/algorithm/cloudy-days-82a872ec/?source=list_view
/*
class Test{
	public static int convert(String str){
		int n=Integer.parseInt(str);
		return n;
	}
	public static void lastFuel(List<Integer> l,int c,List<Integer> re){
		for(int i=0;i<l.size();i++){
			if(i%2==1&&l.get(i)==c){c=l.get(i-1);re.add(c);}
		}
	}
	public static void result(List<Integer> l,int c,List<Integer> re){
		for(int i=0;i<l.size();i++){
			if(i%2==0&&l.get(i)==c){
				c=l.get(i+1);re.add(c);
			}
		}
	}
	public static void main(String... args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine(); String[] strarr=str.split(" ");
		int n=convert(strarr[0]); int m=convert(strarr[1]);
		int f=convert(strarr[2]); int c=convert(strarr[3]);
		List<Integer> l=new ArrayList<>(); int count=0;
		List<Integer> re=new ArrayList<>();
		for(int i=0;i<=m;i++){
			str=br.readLine(); strarr=str.split(" ");
			n=convert(strarr[0]); m=convert(strarr[1]);
			l.add(n); l.add(m);
		}re.add(c);
		while(f>1){result(l,c,re);f--;}
		lastFuel(l,re.get(re.size()-2),re);
		System.out.println(re);
	}
}
/**/


//https://www.hackerearth.com/problem/algorithm/find-mex-62916c25/?source=list_view
/*
class Test{
	public static int check(List<Integer> l,List<Integer> val){
		int n=val.size(),j=0,temp=0;
		while(j<n){
			temp=j;
			if(!l.contains(temp)){}
			j++;
		}
		return temp;
	}
	public static void main(String... args)throws Exception{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(); 
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine(); String[] strarr=str.split(" ");
		List<Integer> l=new ArrayList<>();  List<Integer> val=new ArrayList<>(); 
		for(int i=0;i<n;i++){
			int temp=Integer.parseInt(strarr[i]);
			l.add(temp);
		}int k=0;
		while(k<=n){
			for(int i=1;i<k;i++){//System.out.print(i+" ");}System.out.println();
			if(!l.contains(i)){val.add(i);}}
			k++;
		} k=val.size()-1;val.remove(k);k=check(l,val); val.add(k);
		val.add(0); Collections.sort(val);
		System.out.println(val);
	}
	
}
/**/


//https://www.hackerearth.com/problem/algorithm/optimal-network-expansion-de452a46/?source=list_view
/*
class Test{
	static int convert(String str){ int n=Integer.parseInt(str);
	return n;}
	public static void check(List<Integer> l,List<Integer> A){
		for(int i=0;i<1;i++){
			int temp1=l.get(i); int temp2=l.get(i+1);
			addData(temp1,l,A); l.remove(0); addData(temp2,l,A); l.remove(0);
		}
	}
	public static void addData(int temp,List<Integer> l,List<Integer> li){
		for(int i=0;i<l.size();i++){
			if(temp==l.get(i)){li.add(temp);}
		}
	}
	public static ArrayList<Integer> removeDupli(ArrayList<Integer> l){
		Set<Integer> set=new LinkedHashSet<>();
		set.addAll(l); l.clear(); l.addAll(set);
		return l;
		
	}
	public static void main(String... args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine(); String[] strarr=str.split(" ");
		int u=0,v=0; List<Integer> l=new ArrayList<>();
		List<Integer> re=new ArrayList<>();
		ArrayList<Integer> A=new ArrayList<>(); ArrayList<Integer> B=new ArrayList<>();
		ArrayList<Integer> C=new ArrayList<>(); ArrayList<Integer> D=new ArrayList<>();
		int n=convert(strarr[0]); int m=convert(strarr[1]); int k=convert(strarr[2]);
		for(int i=0;i<m;i++){
			str=br.readLine(); strarr=str.split(" ");
			u=convert(strarr[0]); v=convert(strarr[1]);
			l.add(u); l.add(v);
		}
		check(l,A); for(int i=0;i<3;i++){check(l,B);} B=removeDupli(B);
		for(int i=0;i<4;i++){check(l,C);} C=removeDupli(C);
		for(int i=0;i<3;i++){check(l,D);} D=removeDupli(D);
		
		System.out.println(A); System.out.println(B);
		System.out.println(C); System.out.println(D);
		
	}
	
}


/*
13 11 2
1 2
3 4
4 5
3 6
7 8
7 10
8 10
8 9
11 12
11 13
12 13

/**/

//https://www.hackerearth.com/problem/algorithm/make-palindrome-2-cf7b5be4/?source=list_view
/*
class Test{
	public static String check(char ch,String str,List<Character> l,List<Integer> re){
		int count=0,value=0; StringBuffer sb=new StringBuffer();
		for(int i=0;i<str.length();i++){
			if(ch==str.charAt(i)){count++;}
			else{sb.append(str.charAt(i));}
		}
		re.add(count);
		//System.out.println(ch+" "+count);
		//System.out.println(sb.toString());
		return sb.toString();
	}
	public static void main(String... args){
		String str="abb"; String j=""; //str="aaabaabbfcfccdeef";
		List<Character> l=new ArrayList<>(); List<Integer> re=new ArrayList<>();
		for(int i=0;i<str.length();i++){l.add(str.charAt(i));}
		char ch=' '; ch=str.charAt(0); int count=0;
		j=check(ch,str,l,re);
		while(j.length()>=1){
			ch=j.charAt(0);
			j=check(ch,j,l,re);
			//System.out.println(j);
		}	
		for(int i=0;i<re.size();i++){
			if(re.get(i)%2==0){count=0;}
			else{count++;}
		}
		if(count%2==0){count=1;}
		System.out.println(count); 
	}
}
/**/

//https://www.hackerearth.com/problem/algorithm/range-queries-7-0a9ff8eb/?source=list_view
/*
import java.io.*;
import java.util.*;


public class Test {
    public static int convert(String str){
		int n=Integer.parseInt(str);
		return n;
	}
    public static int binary(int n,int k,List<Integer> re){
		List<Integer> l=new ArrayList<>(); int count=0;
		while(n>0){
			int temp=n%2;
			n=n/2; l.add(temp);
		}
		for(int i=0;i<l.size();i++){if(i==k&&l.get(i)==1){count++;}}
		if(count>0){re.add(count);}
		return 0;
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         while(N>0){
         String[] strarr = br.readLine().split(" ");
        int s=convert(strarr[0]); int e=convert(strarr[1]); int k=convert(strarr[2]);
        List<Integer> l=new ArrayList<>(); List<Integer> re=new ArrayList<>();
		for(int i=s;i<=e;i++){l.add(i);} //System.out.println(l);
		for(int i=0;i<l.size();i++){binary(l.get(i),k-1,re);}
		System.out.println(re.size());N--;}
    }
    
}
/**/

//https://www.hackerearth.com/problem/algorithm/swap-sum-786eb7eb/?source=list_view
/*
class Test{
	public static int convert(String str){
		int n=Integer.parseInt(str);
		return n;
	}
	public static void listData(String str,List<Integer> l,int n){
		String[] strarr=str.split(" ");
		for(int i=0;i<n;i++){int temp=convert(strarr[i]);l.add(temp);}
	}
	public static void result(List<Integer> l1,List<Integer> l2,int n){
		for(int i=0;i<l1.size();i++){
			if(n==l2.get(i)){int temp=l2.get(i);l1.set(i,temp);}
		}
	}
	public static void main(String... args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		List<Integer> b=new ArrayList<>(); List<Integer> v=new ArrayList<>();
		Scanner sc=new Scanner(System.in); List<Integer> re=new ArrayList<>();
		int t=sc.nextInt(); List<Integer> r=new ArrayList<>();
		while(t>0){int sum=0;
		String str=br.readLine(); String[] strarr=str.split(" ");
		int n=convert(strarr[0]); int k=convert(strarr[1]);
		str=br.readLine(); List<Integer> l1=new ArrayList<>();listData(str,l1,n);
		str=br.readLine(); List<Integer> l2=new ArrayList<>();listData(str,l2,n);
		for(int i=0;i<n;i++){v.add(l2.get(i));} int bi=v.size()-1;
		for(int i=0;i<n;i++){r.add(l1.get(i));} 
		Collections.sort(v); Collections.sort(r); int si=r.size()-1;
		if(r.get(si)>v.get(si)){bi--;}
		for(int i=0;i<k;i++){b.add(v.get(bi));bi--;}
		for(int i=0;i<b.size();i++){result(l1,l2,b.get(i));}
		for(int i=0;i<n;i++){sum=sum+l1.get(i);} re.add(sum);
		r.clear();b.clear();v.clear();t--;
		}for(int i=0;i<re.size();i++){System.out.println(re.get(i));}
	}
	
}
/**/



//https://www.hackerearth.com/problem/algorithm/perfect-cube-2-5a1254ac/?source=list_view
/*
class Test{
	public static int cubing(int n){
		int r=3; int k=n;
		while(r>1){
			n=k*n; r--;
		}
		return n;
	}
	public static void values(int k,int n,List<Integer> re,List<Integer> l){
		for(int i=0;i<n;i++){if(k!=i){re.add(l.get(i)*l.get(k));}}
		
	}
	public static List<List<Integer>> generateSubarray(List<Integer> l){
		 List<List<Integer>> subarrays = new ArrayList<>();
		 for (int i = 0; i < l.size(); i++) {
            for (int j = i + 1; j <= l.size(); j++) {
                List<Integer> subarray = new ArrayList<>();
                for (int k = i; k < j; k++) {subarray.add(l.get(k));}
                subarrays.add(subarray);
            }
        }
        return subarrays;
	}
	public static void againLoop(List<Integer> l,List<Integer> re){
		int temp=1;
		if(l.size()>2){
			for(int i=0;i<l.size();i++){temp=temp*l.get(i);}
		}
		if(temp>1)re.add(temp);//System.out.println(temp);
	}
	public static void main(String... args)throws Exception{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(); List<Integer> re=new ArrayList<>();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine(); String[] strarr=str.split(" ");
		List<Integer> l=new ArrayList<>(); List<Integer> cubes=new ArrayList<>(); 
		
		for(int i=0;i<n;i++){int temp=Integer.parseInt(strarr[i]);l.add(temp);}
		for(int i=1;i<=100;i++){int count=cubing(i);cubes.add(count);}
		for(int i=0;i<n;i++){int temp=i;values(temp,n,re,l);
		}
		List<List<Integer>> subarrays = generateSubarray(l);
		for (List<Integer> subarray : subarrays) {
            againLoop(subarray,re);
        }
		Set<Integer> set=new LinkedHashSet<>();
		set.addAll(re); re.clear(); re.addAll(set);
		int count1=0;System.out.println(re); //System.out.println(cubes);
		
		for(int i=0;i<re.size();i++){if(cubes.contains(re.get(i))){count1++;}}
		System.out.println(count1);
	}
}
/**/


/*
import java.util.ArrayList;
import java.util.List;
public class CombinationGenerator {
    public static void generateCombinations(int[] arr) {
        for (int length = 1; length <= arr.length; length++) {
            List<Integer> combination = new ArrayList<>();
            generateCombinationsUtil(arr, length, 0, combination);
        }
    }
    private static void generateCombinationsUtil(int[] arr, int length, int start, List<Integer> combination) {
        if (combination.size() == length) {
            System.out.println(combination);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            combination.add(arr[i]);  // Add element to the current combination
            generateCombinationsUtil(arr, length, i + 1, combination);  // Recur for the next element
            combination.remove(combination.size() - 1);  // Backtrack (remove the last added element)
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        generateCombinations(arr);
    }
}
/**/

/*
import java.awt.*;
import javax.swing.*;
class MyFrame extends JFrame
{ JLabel l1,l2,l3,l4,l5,l6,l7;
JTextField tf;
JPasswordField pf;
JCheckBox cb1,cb2,cb3;
JRadioButton rb1,rb2;
JList l;
JComboBox cb;
JTextArea ta;
JButton b;
Container c;
MyFrame() //constructor
{
this.setVisible(true);
this.setSize(150,500);
this.setTitle("SWING GUI COMPONENTS EXAMPLE");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
c=this.getContentPane();
c.setLayout(new FlowLayout());
c.setBackground(Color.green);
l1=new JLabel("User Name");
l2= new JLabel("password");
l3= new JLabel("Qualification");
l4= new JLabel("User Gender");
l5= new JLabel("Technologies");
l6= new JLabel("UserAddress");
l7= new JLabel("comments");
tf=new JTextField(15);
tf.setToolTipText("TextField");
pf=new JPasswordField(15);
pf.setToolTipText("PasswordField");
cb1=new JCheckBox("BSC",false);
cb2=new JCheckBox("MCA",false);
cb3=new JCheckBox("PHD",false);
rb1=new JRadioButton("Male",false);
rb2=new JRadioButton("Female",false);
ButtonGroup bg=new ButtonGroup();
bg.add(rb1); bg.add(rb2);
String[] listitems={"cpp","c","java"};
l=new JList(listitems);
String[] cbitems={"hyd","pune","bangalore"};
cb=new JComboBox(cbitems);
ta=new JTextArea(5,20);
b=new JButton("submit");
c.add(l1); c.add(tf); c.add(l2); c.add(pf);

c.add(l3); c.add(cb1); c.add(cb2); c.add(cb3);
c.add(l4); c.add(rb1); c.add(rb2); c.add(l5);
c.add(l); c.add(l6); c.add(cb); c.add(l7);
c.add(ta); c.add(b);
}
}
class SwingDemo
{ public static void main(String[] args)
{ MyFrame f=new MyFrame();
}
};
/**/

/*
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class MyFrame extends JFrame implements ChangeListener
{ JColorChooser cc;
Container c;
MyFrame()
{ this.setVisible(true);
this.setSize(500,500);
this.setTitle("SWING GUI COMPONENTS EXAMPLE");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
c=getContentPane();
cc=new JColorChooser();
cc.getSelectionModel().addChangeListener(this);
c.add(cc);
}
public void stateChanged(ChangeEvent c)
{ Color color=cc.getColor();
JFrame f=new JFrame();
f.setSize(400,400);
f.setVisible(true);
f.getContentPane().setBackground(color);
}
}
class Demo
{ public static void main(String[] args)
{ MyFrame f=new MyFrame();
}
};
/**/

/*
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class MyFrame extends JFrame implements ActionListener
{ JFileChooser fc;
Container c;
JLabel l;
JTextField tf;
JButton b;
MyFrame()
{ this.setVisible(true);
this.setSize(500,500);
this.setTitle("SWING GUI COMPONENTS EXAMPLE");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
c=getContentPane();
l=new JLabel("Select File:");
tf=new JTextField(25);
b=new JButton("BROWSE");
this.setLayout(new FlowLayout());
b.addActionListener(this);
c.add(l); c.add(tf); c.add(b);
}
public void actionPerformed(ActionEvent ae)
{ class FileChooserDemo extends JFrame implements ActionListener
{ FileChooserDemo()
{ Container c=getContentPane();
this.setVisible(true);
this.setSize(500,500);
fc=new JFileChooser();
fc.addActionListener(this);
fc.setLayout(new FlowLayout());
c.add(fc);
}
public void actionPerformed(ActionEvent ae)
{ File f=fc.getSelectedFile();
String path=f.getAbsolutePath();
tf.setText(path);
this.setVisible(false);
}
}
new FileChooserDemo();
}
}
class Demo
{ public static void main(String[] args)
{ MyFrame f=new MyFrame();
}
};
/**/

//Prime numbers : 2,3,5,7,11,13,17 : 
//100 : 

/*
class Test{
	static int isPrime(int n){
		if(n==1){return 0;}
		for(int i=2;i<n;i++){
			if(n%i==0){return 0;}
		}
		return 1;
	}
	public static void main(String... args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=1;i<=n;i++){
			if(isPrime(i)==1){System.out.print(i+" ");}
		}
	}
}
/**/

/*
class Main{
    public static String OccurancesofString(String str,int n,char ch){
        int count=0;
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<n;i++){
            if(str.charAt(i)==ch){
                count++;
            }else{sb.append(str.charAt(i));}
        }
        System.out.println(ch+" "+count);
        return sb.toString();
    }
    public static void main(String... args){
        String str="adfasdfasdasdfasdf";
        int n=str.length();
        char ch=str.charAt(0);
        String result=OccurancesofString(str,n,ch);
        while(result.length()>0){
            ch=result.charAt(0); n=result.length();
            result=OccurancesofString(result,n,ch);
        }
        System.out.println(result);
    }
    
}
*/

/*
import java.util.*;
class Main{
    public static int value(String str,int n,char ch,List<Integer> l){
        int count=0;
        for(int i=0;i<n;i++){
            if(ch==str.charAt(i)){count++;}
        }l.add(count);
        return 0;
    }
    public static void main(String... args){
        String str="adsfasdflkajsfdasdfa";
        Map<Character,Integer> mp=new HashMap<>();
        List<Integer> l=new ArrayList<>();
        Set<Character> li=new HashSet<>(); int n=str.length();
        for(int i=0;i<n;i++){ li.add(str.charAt(i));}int j=0,count=0;
        List<Character> va=new ArrayList<>(li);
        for(int i=0;i<va.size();i++){
            value(str,n,va.get(i),l);
        } int i=0;
        for(char c: va){mp.put(c,l.get(i));i++;}
        
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
       
    }
    
}
/**/


