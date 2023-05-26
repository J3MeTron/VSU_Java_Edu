#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <cstring>
using namespace std;

#define MAX_SIZE 100

struct Variant1 {
    char field1[4]; 
    char field2[15]; 
};

struct Variant2 {
    char field3[10];
    char field4[100];
};

struct Structure {
    char type;
    union {
        Variant1 variant1;
        Variant2 variant2;
    } data;
};

class Database {
private:
    Structure database[MAX_SIZE];
    int count;

public:

    Database() : count(0) {}

    void addEntry() {
        setlocale(LC_ALL, "");
        if (count >= MAX_SIZE) {
            cout << "Ошика: максимум записей привышено\n";
            return;
        }

        Structure newEntry;

        cout << "Добавить мобильный номер телефона(1) или Индекс и адрес(2): ";
        cin >> newEntry.type;

        if (newEntry.type == '1') {
            cout << "Введите код страны(до 4х символов без +): ";
            cin >> newEntry.data.variant1.field1;
            cout << "Введите номер "; 
            cin.ignore(); // Игнорировать символ новой строки
            cin.getline(newEntry.data.variant1.field2, sizeof(newEntry.data.variant1.field2));
        }
        else if (newEntry.type == '2') {
            cout << "Введите индекс адресата: ";
            cin >> newEntry.data.variant2.field3;
            cout << "Введите адрес):: ";
            cin >> newEntry.data.variant2.field4;
        }
        else {
            cout << "Ошибка: не корректный вариант\n";
            cin.ignore();
            return;
        }

        database[count++] = newEntry;
        cout << "Запись успешно добавлена\n";
    }

    void deleteEntry() {
        setlocale(LC_ALL, "");
        if (count == 0) {
            cout << "База данных пуста\n";
            return;
        }

        int index;
        cout << "Введите номер записи для удаления (от 1 до " << count << "): ";
        cin >> index;

        if (index < 1 || index > count) {
            cout << "Ошибка: Неверный номер записи\n";
            cin.ignore();
            return;
        }

        for (int i = index - 1; i < count - 1; i++) {
            database[i] = database[i + 1];
        }

        count--;
        cout << "Запись успешно удалена\n";
    }

    void printEntries() {
        setlocale(LC_ALL, "");
        if (count == 0) {
            cout << "База данных пуста\n";
            return;
        }

        cout << "Содержимое базы данных:\n";
        for (int i = 0; i < count; i++) {
            Structure entry = database[i];

            cout << "Запись " << i + 1 << "\n";
            if (entry.type == '1') {
                cout << "Номера телефонов\n";
                cout << "Код страны: +" << entry.data.variant1.field1 << "\n";
                cout << "Номер: " << entry.data.variant1.field2 << "\n";
            }
            else if (entry.type == '2') {
                cout << "Индексы и адреса\n";
                cout << "Индекс: " << entry.data.variant2.field3 << "\n";
                cout << "Адрес: " << entry.data.variant2.field4 << "\n";
            }

            cout << "------------------------\n";
        }
    }
};

int main() {
    setlocale(LC_ALL, "");
    Database db;
    int choice;

    do {
        cout << "Меню:\n";
        cout << "1. Добавить запись\n";
        cout << "2. Удалить запись\n";
        cout << "3. Вывести все имеющиеся записи\n";
        cout << "4. Выход\n";
        cout << "Введите свой вариант: ";
        cin >> choice;

        switch (choice) {
        case 1:
            db.addEntry();
            break;
        case 2:
            db.deleteEntry();
            break;
        case 3:
            db.printEntries();
            break;
        case 4:
            cout << "Выход...\n";
            break;
        default:
            cout << "Не корректный вариант\n";
            break;
        }

        cout << "------------------------\n";
    } while (choice != 4);

    return 0;
}
