import java.io.*;


public class CharStack
{
  private char[] m_data;        
  
  private int m_ptr;
  
  public CharStack(int size)
  {
      m_ptr = 0;                 
      m_data = new char[(size > 1 ? size : 10)]; 
  }
  
  public void push(char c)
  {
      if (m_ptr >= m_data.length) 
      {
       
         char[] tmp = 
            new char[m_data.length * 2];
      
         System.arraycopy(m_data, 0, 
                          tmp, 0, 
                          m_data.length);
         m_data = tmp;
      }
      m_data[m_ptr++] = c;
  }
      
  public char pop()
  {
    try
    {
        return m_data[--m_ptr];
        
    } catch(ArrayIndexOutOfBoundsException ex){
        System.out.println("Stack is Empty");
        return "x".charAt(0);

    }
      
  }
  public boolean hasMoreElements()
  {
      return (m_ptr != 0);
  }
  

  public static void main(String[] argv) 
      throws IOException
  {
      CharStack s = new CharStack(10);
      int i;

      while ( (i = System.in.read()) != '\n' )
      {
         s.push((char) i);
      }

      for (int j = 0; j < 100; j++)
      {
         System.out.write(s.pop());
      }
      System.out.println();
    }
}
