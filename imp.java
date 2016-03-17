import java.util.*;
import java.lang.*;
import java.io.*;

class imp {
    
    public int vocab_size = 0;
    
    //for number of occurence of group
    public HashMap<String, Integer> hm = new HashMap<String, Integer>();

    //words in individual groups
    public HashMap<String, Integer> guns = new HashMap<String, Integer>();
    public HashMap<String, Integer> mideast = new HashMap<String, Integer>();
    public HashMap<String, Integer> polmisc = new HashMap<String, Integer>();
    public HashMap<String, Integer> baseball = new HashMap<String, Integer>();
    public HashMap<String, Integer> relmisc = new HashMap<String, Integer>();
    public HashMap<String, Integer> hockey = new HashMap<String, Integer>();
    public HashMap<String, Integer> autos = new HashMap<String, Integer>();
    public HashMap<String, Integer> motorcycles = new HashMap<String, Integer>();
    
    Map<String, Double> temphm = new HashMap<String, Double>();
    
    HashMap<String, Integer> vocabhm = new HashMap<String, Integer>();
    
    public void hashify(File inFile) {
        //System.out.println("hashify");
        hm.put("guns", 0);
        hm.put("mideast", 0);
        hm.put("polmisc", 0);
        hm.put("relmisc", 0);
        hm.put("baseball", 0);
        hm.put("hockey", 0);
        hm.put("autos", 0);
        hm.put("motorcycles", 0);

        try {
            //FileInputStream fstream = new FileInputStream("file_small.txt");
            FileInputStream fstream = new FileInputStream(inFile);
            Scanner s = new Scanner(fstream);
            while(s.hasNextLine()) {
                String s1 = s.nextLine();
                if(s1.length() >= 4) {
                    if(s1.substring(0, 4).equals("rec.")) {
                        if (s1.substring(4, 9).equals("autos")) {
                            fillHash(autos, s1);
                            hm.put("autos", hm.get("autos") + 1);
                        }
                        else if (s1.substring(4, 15).equals("motorcycles")) {
                            fillHash(motorcycles, s1);
                            hm.put("motorcycles", hm.get("motorcycles") + 1);
                        }
                        else if (s1.substring(4, 18).equals("sport.baseball")) {
                            fillHash(baseball, s1);
                            hm.put("baseball", hm.get("baseball") + 1);
                        }
                        else if (s1.substring(4, 17).equals("politics.misc")) {
                            fillHash(polmisc, s1);
                            hm.put("polmisc", hm.get("polmisc") + 1);
                        }                       
                        else if (s1.substring(4, 16).equals("sport.hockey")) {
                            fillHash(hockey, s1);
                            hm.put("hockey", hm.get("hockey") + 1);
                        }                                 
                        else if (s1.substring(4, 20).equals("politics.mideast")) {
                            fillHash(mideast, s1);
                            hm.put("mideast", hm.get("mideast") + 1);
                        }                                 
                        else if (s1.substring(4, 17).equals("politics.guns")) {
                            fillHash(guns, s1);
                            hm.put("guns", hm.get("guns") + 1);
                        }                                      
                        else {
                            fillHash(relmisc, s1);   
                            hm.put("relmisc", hm.get("relmisc") + 1); 
                        }
                        
                    }
                }
                if(s1.length() >= 5) {
                    if(s1.substring(0, 5).equals("talk.")) {
                        if (s1.substring(5, 10).equals("autos")) {
                            fillHash(autos, s1);
                            hm.put("autos", hm.get("autos") + 1);
                        }
                        else if (s1.substring(5, 16).equals("motorcycles")) {
                            fillHash(motorcycles, s1);
                            hm.put("motorcycles", hm.get("motorcycles") + 1);
                        }
                        else if (s1.substring(5, 19).equals("sport.baseball")) {
                            fillHash(baseball, s1);
                            hm.put("baseball", hm.get("baseball") + 1);
                        }
                        else if (s1.substring(5, 18).equals("politics.misc")) {
                            fillHash(polmisc, s1);
                            hm.put("polmisc", hm.get("polmisc") + 1);
                        }         
                        else if (s1.substring(5, 17).equals("sport.hockey")) {
                            fillHash(hockey, s1);
                            hm.put("hockey", hm.get("hockey") + 1);
                        }                                 
                        else if (s1.substring(5, 21).equals("politics.mideast")) {
                            fillHash(mideast, s1);
                            hm.put("mideast", hm.get("mideast") + 1);
                        }                                              
                        else if (s1.substring(5, 18).equals("politics.guns")) {
                            fillHash(guns, s1);
                            hm.put("guns", hm.get("guns") + 1);
                        }                          
                        else {
                            fillHash(relmisc, s1);   
                            hm.put("relmisc", hm.get("relmisc") + 1); 
                        }
                        
                    }
                }
            }
            
            //vocab_size += guns.size() + mideast.size() + polmisc.size() + baseball.size() + relmisc.size() + hockey.size() + autos.size() + motorcycles.size();
            
            temphm.put("guns", Math.log((double) guns.size()/(double) vocab_size));
            temphm.put("mideast", Math.log((double) mideast.size()/(double) vocab_size));
            temphm.put("polmisc", Math.log((double) polmisc.size()/(double) vocab_size));
            temphm.put("relmisc", Math.log((double) relmisc.size()/(double) vocab_size));
            temphm.put("baseball", Math.log((double) baseball.size()/(double) vocab_size));
            temphm.put("hockey", Math.log((double) hockey.size()/(double) vocab_size));
            temphm.put("autos", Math.log((double) autos.size()/(double) vocab_size));
            temphm.put("motorcycles", Math.log((double) motorcycles.size()/(double) vocab_size));            
	    } catch (FileNotFoundException en) {
	        System.out.println("File not found");
	    }
	    
	    try {
            FileInputStream fstream1 = new FileInputStream(inFile);
            Scanner sC = new Scanner(fstream1);
            while(sC.hasNext()) {
                String s1 = sC.next();
                if(vocabhm.get(s1) != null) {
        			int value = vocabhm.get(s1); 
        			vocabhm.put(s1, value + 1);
        		}
        		else {
        		    vocab_size += 1;
        			vocabhm.put(s1, 1);
            	}
            }
        } catch(FileNotFoundException en) {
            System.out.println("File not found");
        }

		/*Iterator<String> it = autos.keySet().iterator();
		while(it.hasNext()) {
			String tmp = it.next();
			System.out.println("key = " + tmp + " ; value = " + autos.get(tmp));
		}*/
        return ;
    }

    public void fillHash(HashMap<String, Integer> hm, String s1) {
        //System.out.println("fillHash");
        String[] tokens = s1.split(" ");
        int i = 1;
        while(i < tokens.length) {
            String temp = tokens[i];
            if(hm.get(temp) != null) {
    			int value = hm.get(temp); 
    			hm.put(temp, value + 1);
    		}
    		else {
    			hm.put(temp, 1);
        	}        
        	i += 1;
        }
		
		/*Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()) {
			String tmp = it.next();
			System.out.println("key = " + tmp + " ; value = " + hm.get(tmp));
		}*/
        
        return ;
    }
    
    public double word_classlog(String word, String group) {
        if (group.equals("autos")) {
            if(autos.get(word) != null)
                return Math.log((double) (autos.get(word) + 1) /(double) (autos.size() + vocab_size));
            return Math.log((double) (0 + 1) /(double) (autos.size() + vocab_size));
        }
        else if (group.equals("politics.guns")) {
            if(guns.get(word) != null)
                return Math.log((double) (guns.get(word) + 1) /(double) (guns.size() + vocab_size));
            return Math.log((double) (0 + 1) /(double) (guns.size() + vocab_size));
        }
        else if (group.equals("politics.mideast")) {
            if(mideast.get(word) != null)
                return Math.log((double) (mideast.get(word) + 1) /(double) (mideast.size() + vocab_size));
            return Math.log((double) (0 + 1) /(double) (mideast.size() + vocab_size));
        }
        else if (group.equals("politics.misc")) {
            if(polmisc.get(word) != null)
                return Math.log((double) (polmisc.get(word) + 1) /(double) (polmisc.size() + vocab_size));
            return Math.log((double) (0 + 1) /(double) (polmisc.size() + vocab_size));
        }
        else if (group.equals("religion.misc")) {
            if(relmisc.get(word) != null)
                return Math.log((double) (relmisc.get(word) + 1) /(double) (relmisc.size() + vocab_size));
            return Math.log((double) (0 + 1) /(double) (relmisc.size() + vocab_size));
        }
        else if (group.equals("motorcycles")) {
            if(motorcycles.get(word) != null)
                return Math.log((double) (motorcycles.get(word) + 1) /(double) (motorcycles.size() + vocab_size));
            return Math.log((double) (0 + 1) /(double) (motorcycles.size() + vocab_size));
        }
        else if (group.equals("sport.hockey")) {
            if(hockey.get(word) != null)
                return Math.log((double) (hockey.get(word) + 1) /(double) (hockey.size() + vocab_size));
            return Math.log((double) (0 + 1) /(double) (hockey.size() + vocab_size));
        }
        else {
            if(baseball.get(word) != null)
                return Math.log((double) (baseball.get(word) + 1) /(double) (baseball.size() + vocab_size));
            return Math.log((double) (0 + 1) /(double) (baseball.size() + vocab_size));
        }
    }
    
    public boolean hash_cmp(String input) {
        //HashMap<String, HashMap<String, Integer> > hashifyhm = hashify(inFile);
        //HashMap<String, Integer> wordGrphm = wordGrp(inFile);
        //System.out.println("hash_cmp");
        String[] tokens = input.split(" ");
        String res = tokens[0];
        if(res.substring(0, 4).equals("rec.")) {
            res = res.substring(4);
        }
        else if(res.substring(0, 5).equals("talk.")) {
            res = res.substring(5);
        }
        Map<String, Double> var = new HashMap<String, Double>();
        var.put("politics.guns", temphm.get("guns"));
        var.put("politics.mideast", temphm.get("mideast"));
        var.put("politics.misc", temphm.get("polmisc"));
        var.put("religion.misc", temphm.get("relmisc"));
        var.put("sport.baseball", temphm.get("baseball"));
        var.put("sport.hockey", temphm.get("hockey"));
        var.put("autos", temphm.get("autos"));
        var.put("motorcycles", temphm.get("motorcycles"));
        int i = 1;
        int vocab = vocab_size;
        while(i < tokens.length) {
            String temp = tokens[i]; //current word
            double max = -1000000000;
            Iterator<String> it = var.keySet().iterator();
            while(it.hasNext()) {
                String tmp = it.next(); //Group
                double t1 = var.get(tmp);
                var.put(tmp, t1 + word_classlog(temp, tmp));
            }
        	i += 1;
        }

        double max = -1000000000;
        String curr = "";
        Iterator<String> it = var.keySet().iterator();
        while(it.hasNext()) {
            String tmp = it.next();
            if(var.get(tmp) > max) {
                max = var.get(tmp);
                curr = tmp;
            }
        }
        
        /*System.out.println("curr = " + curr);

        if(res.length() >= curr.length()) {   
            System.out.println("res = " + res.substring(0, curr.length()));
        }*/
        
        if(res.length() >= curr.length()) {    
            if(curr.equals(res.substring(0, curr.length()))) {
                return true;
            }
        }
        return false;
    }
    
    public double hash_cmpFile(File inFile) {
        //System.out.println("hash_cmpFile");
        try {
            FileInputStream fstream = new FileInputStream(inFile);
            Scanner s = new Scanner(fstream);
            int res = 0;
            int i = 0;
            while(s.hasNextLine()) {
                String s1 = s.nextLine();
                if(hash_cmp(s1)) {//check about this inFile
                    res += 1;
                }
                i += 1;
            }
            return ((double) res/ (double)i);
	    } catch (FileNotFoundException en) {
	        System.out.println("File not found");
	    }
	    return 0;
    }

    public static String randGroup() {
        Random rand = new Random();
        int n = rand.nextInt(8);
        switch(n) {
            case 0 :
                return "politics.guns";
                //break;
            case 1 :
                return "politics.mideast";
                //break;
            case 2 :
                return "politics.misc";
                //break;
            case 3 :
                return "religion.misc";
                //break;
            case 4 :
                return "sport.hockey";
                //break;
            case 5 :
                return "sport.baseball";
                //break;
            case 6 :
                return "autos";
                //break;
            case 7 :
                return "motorcycles";
                //break;
        }
        return null;
    }
    
    public static double randGroupProb(File inFile) {
        try {
            FileInputStream fstream = new FileInputStream(inFile);
            Scanner s = new Scanner(fstream);
            int res = 0;
            int i = 0;
            while(s.hasNextLine()) {
                String s1 = s.nextLine();
                if(s1.substring(0, 4).equals("rec.")) {
                    s1 = s1.substring(4);
                }
                else if(s1.substring(0, 5).equals("talk.")) {
                    s1 = s1.substring(5);
                }
                String s2 = randGroup();
                if(s2.equals(s1.substring(0, s2.length()))) {
                    res += 1;
                }
                i += 1;
            }
            return ((double) res/ (double)i);
	    } catch (FileNotFoundException en) {
	        System.out.println("File not found");
	    }
	    return 0;
    }
    
}