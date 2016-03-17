import java.util.*;
import java.lang.*;
import java.io.*;

class wrapper {
    
    public static void main (String[] args) {
        
        double average = 0;
        
        imp mytest0 = new imp();
        imp mytest1 = new imp();
        imp mytest2 = new imp();
        imp mytest3 = new imp();
        imp mytest4 = new imp();
        
        File inFile0 = new File("file_0.txt");
        File inFile1 = new File("file_1.txt");
        File inFile2 = new File("file_2.txt");
        File inFile3 = new File("file_3.txt");
        File inFile4 = new File("file_4.txt");
        
        mytest0.hashify(inFile0);
        mytest0.hashify(inFile1);
        mytest0.hashify(inFile2);
        mytest0.hashify(inFile3);
        average += mytest0.hash_cmpFile(inFile4);

        mytest1.hashify(inFile4);
        mytest1.hashify(inFile1);
        mytest1.hashify(inFile2);
        mytest1.hashify(inFile3);
        average += mytest1.hash_cmpFile(inFile0);
        
        mytest2.hashify(inFile0);
        mytest2.hashify(inFile4);
        mytest2.hashify(inFile2);
        mytest2.hashify(inFile3);
        average += mytest2.hash_cmpFile(inFile1);
        
        mytest3.hashify(inFile0);
        mytest3.hashify(inFile1);
        mytest3.hashify(inFile4);
        mytest3.hashify(inFile3);
        average += mytest3.hash_cmpFile(inFile2);
        
        mytest4.hashify(inFile0);
        mytest4.hashify(inFile1);
        mytest4.hashify(inFile2);
        mytest4.hashify(inFile4);
        average += mytest4.hash_cmpFile(inFile3);
        
        average = average/5;

        /*Iterator<String> it = mytest.autos.keySet().iterator();
		while(it.hasNext()) {
			String tmp = it.next();
			System.out.println("key = " + tmp + " ; value = " + mytest.autos.get(tmp));
		}*/
		
        /*Iterator<String> it = mytest.temphm.keySet().iterator();
		while(it.hasNext()) {
			String tmp = it.next();
			System.out.println("key = " + tmp + " ; value = " + mytest.temphm.get(tmp));
		}*/

        System.out.println(average);

		//System.out.println(mytest.vocab_size);
        double var = 0;
        var += mytest0.randGroupProb(inFile0);
        var += mytest0.randGroupProb(inFile1);
        var += mytest0.randGroupProb(inFile2);
        var += mytest0.randGroupProb(inFile3);
        var += mytest0.randGroupProb(inFile4);
        var = var/5;
        System.out.println(var);
        System.out.println(average - var);
		//System.out.println(mytest.hash_cmpFile(inFile0));
		//System.out.println(mytest.multiplier(inFile0));
		//System.out.println(mytest.randGroupProb(inFile4));
    }
}