using System;
using System.IO;


class Program
{
        static void FindWord(string N) {
        N += "\\";
        Console.WriteLine("Введите длину слова: \n");   
        int Length = Convert.ToInt32(Console.ReadLine());

        string word = "";
        for (int i = 0; i < N.Length; i++) 
        {
            if (N[i] != ' ')
            {
                word += N[i];
            }
            else 
            {
                if (Length == word.Length) 
                {
                    Console.WriteLine(word);
                    word = "";
                }
            }
        }   

        }
    

    public const string startText = "Выбрать без повторений из текста все слова заданной длины.\nСловом считается непрерывная последовательность символов(строчных и прописных) А-Я, A-Z и цифр\n";
    public static void Main()
    {
        Console.WriteLine(startText);

        String line = "";
       try
         {
             StreamReader sr = new StreamReader("D:\\Education\\JavaVsu\\Practice\\VSU_Java_Edu\\Tasks\\Outsorce other languages\\C#\\Anuta\\forAnuta\\Text.txt");

             line = sr.ReadLine();

             /*if (line == null)
             {
                 throw new ArgumentNullException(paramName: nameof(line), message: "parameter can't be null.");
             }*/

             while (line != null)
             {
                line = sr.ReadLine();
             }

             sr.Close();
             Console.ReadLine();

         }
         catch (Exception e)
         {
             Console.WriteLine("Exception: " + e.Message);
         }

        Console.WriteLine(line);
        FindWord(line);
    }
}