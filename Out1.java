public class Out1
{
    public static void Out(int[][] arr, int sickID)
    {
      for(int i = 0; i < arr.length; i++)
      {
        for(int j = 0; j < arr[i].length; j++)
        {
            if(arr[i][j] == sickID)
            {
               if(j != arr[i].length -1)
               {
                arr[i][j] = arr[i + 1][j];
               } 
               else
            {
                arr[i][j] = arr[i - 1][j];
               }
            }
        }
      }
    }
    public static void main(String[] args) 
    {
        int[][] work = 
    {
        {68,201,121}, 
        {149,188,51},
        {24, 133, 133}, 
        {126, 192, 210}, 
        {37, 210, 126}
    }; 

    }
}