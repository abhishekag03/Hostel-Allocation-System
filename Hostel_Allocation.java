
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class object{
	String name;
	String rollno;
	int dist;
	int index;
	String branch;
	object(String a,String b,int c,int d,String v){
		name=a;
		rollno=b;
		dist=c;
		index=d;
		branch=v;
	}

}
 
class lab1{
	static object[] A;
	static object[] aux;
	public static void sort(object[] A,int n) { 
	 
		aux = new object[n]; 
		mergesort(0, n - 1); 
		}
	
	private static void mergesort(int low, int high) {
		if (low < high) {
		int middle = (low + high) / 2;
		mergesort(low, middle);
		mergesort(middle + 1, high);
		// Combine both the sorted subarrays
		merge(low, middle, high);
		}
		}
	private static void merge(int low, int middle, int high) {
		// Copy contents of A into aux array
		for (int i = low; i <= high; i++) {
		aux[i] = A[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
	// Copy the smallest
		while (i <= middle && j <= high) {
			
			if (aux[i].dist>aux[j].dist) {
			A[k] = aux[i];
			i++;
			} 
			else if (aux[i].dist==aux[j].dist) {
				if (aux[i].index<aux[j].index) {
					A[k]=aux[i];
					i++;
				}
				else {
					A[k]=aux[j];
					j++;
				}
			}
			else {
			A[k] = aux[j];
			j++;
			}
			k++;
			}
		while (i <= middle) {
			A[k] = aux[i];
			k++;
			i++;
			}
			while (j <= high) {
			A[k] = aux[j];
			k++;
			j++;
			}

		
					}



	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Reader.init(System.in);
		int n = Reader.nextInt();
		int m = Reader.nextInt();
		int phdcnt=0,pgcnt=0,ugcnt=0,phda=0,pga=0,uga=0;
		object[] phdarr=new object[n];
		object[] pgarr=new object[n];
		object[] ugarr=new object[n];
		object[] alloted=new object[n];
		for (int i=0;i<n;i++){
			String s = Reader.next();
			String rn = Reader.next();
			String course = Reader.next();
			int dist = Reader.nextInt();
			
			if (course.equals("PhD")){
				object obj = new object(s,rn,dist,i,course);
				phdarr[phdcnt]=obj;
				phdcnt++;
			}
			else if (course.equals("PG")){
				object obj = new object(s,rn,dist,i,course);
				pgarr[pgcnt]=obj;
				pgcnt++;
			}
			else{
				object obj = new object(s,rn,dist,i,course);
				ugarr[ugcnt]=obj;
				ugcnt++;
			}
		}
		A=phdarr;
		sort(phdarr,phdcnt);
//		
//		for (int k=0;k<phdcnt;k++){
//			System.out.println("phd= "+phdarr[k].name);
//		}
//		
//		for (int k=0;k<pgcnt;k++){
//			System.out.println("pg= "+pgarr[k].name);
//		}
		A=pgarr;
		sort(pgarr,pgcnt);
//		for (int k=0;k<pgcnt;k++){
//			System.out.println("pg2= "+pgarr[k].name);
//		}
		A=ugarr;
		sort(ugarr,ugcnt);
		int allot=0;
		int flag=1;
		int flag2=1;
		int num=m/2;
		if (m%2==1) {
			num++;
		}
		
//		int num=(int)Math.ceil(n/2);
//		System.out.println(num);
		if (phdcnt<num){
			num=phdcnt;
			flag=0;
		}
		
		for (int k=0;k<num;k++) {
			alloted[allot]=phdarr[k];
			allot++;
			phda++;
		}
//		if (num<phdcnt && phdarr[num-1].dist==phdarr[num].dist && phdarr[num-1].index>phdarr[num].index) {
////			object temp=phdarr[num-1];
//			alloted[num-1]=phdarr[num];
//		}
//		allot+=num;
//		System.out.println("allot= "+allot);
		num=m/2;
//		System.out.println("num= "+num);
		if (pgcnt<num) {
			num=pgcnt;
			flag2=0;
		}
		for (int k=0;k<num;k++) {
			alloted[allot]=pgarr[k];
			pga++;
			allot++;
			flag2++;
		}
		
//		if (num<pgcnt && pgarr[num-1].dist==pgarr[num].dist && pgarr[num-1].index>pgarr[num].index) {
////			object temp=phdarr[num-1];
//			alloted[num-1]=pgarr[num];
//		}
		
		
//		System.out.println("all= "+allot);
		int ugs=m-allot;
		if (ugcnt<ugs) {
			ugs=ugcnt;
		}
		for (int k=0;k<ugs;k++) {
			alloted[allot]=ugarr[k];
			allot++;
			
		}
//		System.out.println(allot);
		if (allot<m && flag==1) {
			while (phda<=phdcnt &&  allot<m) {
//				System.out.println("yes");
				alloted[allot]=phdarr[phda];
				phda++;
				allot++;
			}
//			alloted[allot]=phdarr[]
		}
		if (allot<m && flag2==1) {
			while (pga<=pgcnt &&  allot<m) {
				alloted[allot]=pgarr[pga];
				pga++;
				allot++;
			}
//			alloted[allot]=phdarr[]
		}
		
		num=ugs;
//		if (num<ugcnt && ugarr[num-1].dist==ugarr[num].dist && ugarr[num-1].index>ugarr[num].index) {
////			object temp=phdarr[num-1];
//			alloted[num-1]=ugarr[num];
//		}
		A=alloted;
		int min=0;
		int in=0;
		for (int j=0;j<m;j++) {
			min=alloted[j].index;
			in=j;
			for (int k=j;k<m;k++) {
//				System.out.println(k);
				if (alloted[k].index<min) {
					min=alloted[k].index;
					in=k;
				}
			}
			object temp=alloted[j];
			alloted[j]=alloted[in];
			alloted[in]=temp;
		}
//		sort(alloted,allot);
		for (int i=0;i<m;i++) {
			System.out.println(alloted[i].name + " " + alloted[i].rollno + " " +alloted[i].branch + " " + alloted[i].dist);
		}
	}

	}

class Reader {
	static BufferedReader reader;
	static StringTokenizer tokenizer;
	/** call this method to initialize reader for InputStream */
	static void init(InputStream input) {
		reader = new BufferedReader(
				new InputStreamReader(input) );
		tokenizer = new StringTokenizer("");
	}
 
	/** get next word */
	static String next() throws IOException {
		while ( ! tokenizer.hasMoreTokens() ) {
			//TODO add check for if necessary
			tokenizer = new StringTokenizer(
					reader.readLine() );
		}
		return tokenizer.nextToken();
	}
 
	static int nextInt() throws IOException {
		return Integer.parseInt( next() );
	}
 
	static double nextDouble() throws IOException {
		return Double.parseDouble( next() );
	}
} 