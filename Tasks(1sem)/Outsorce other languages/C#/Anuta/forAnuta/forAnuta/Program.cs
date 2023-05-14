using System;
using System.IO;


class Program
{
        static void FindWord(string N) {
        N += "\\";
        Console.WriteLine("Введите длину слова: \n");   
        int Length = Convert.ToInt32(Console.ReadLine());

        string word = "";
        string word2 = "";
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

                    if (word != word2)
                    {
                        Console.WriteLine(word);
                        word2 = word;
                        word = "";
                    }
                    else {
                        word2 = word;
                        word = "";
                    }
                }
                
                word = "";
            }
        }   

        }
    

    public const string startText = "Выбрать без повторений из текста все слова заданной длины.\nСловом считается непрерывная последовательность символов(строчных и прописных) А-Я, A-Z и цифр\n";
    public static void Main()
    {
        Console.WriteLine(startText);
        Console.WriteLine("Введите строку: \n");
        String line = Console.ReadLine();
        FindWord(line);
    }
}