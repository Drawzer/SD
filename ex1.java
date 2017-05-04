
import java.util.logging.Level;
import java.util.logging.Logger;

class sd extends Thread{
	static String str = "ahegfnthroahegfnthroahegfnthroahegfnthroahegfnthroahegfnthroahegfnthroahegfnthroahegfnthro";
	static char[] str_ = new char[str.length()];
	static int pos=0;

	public void run(){
                if(pos<str.length()){
		str_[pos]=Character.toUpperCase(str.charAt(pos));	
                System.out.println(str.charAt(pos)+" -> "+ str_[pos]);
                }
	}

	public static void main(String args[]){         
                
                int i;
		sd vet[] = new sd[30];                 
                
                for(i=0; i<30; i++)                   
                {
                    vet[i] = new sd();
                }
		for(i=0; i<30; i++){  
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(sd.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        System.out.println("\ni -> "+ i);
                        if(pos>=30)
                            vet[i].run();
                        else
                            vet[i].start();           
                    
                        if(i == 29 && pos < 80 )        
                           i = 0;
                        
                        if(pos==str.length()-1)
                            i=1000;                                                        
                        pos++;                         
		}
                
                String str2 = new String(sd.str_);
                System.out.printf(sd.str);
		System.out.println("\n");
		System.out.printf(str2);
		System.out.println("\n");
	}
}


//------------------------------------------------------------------------------


