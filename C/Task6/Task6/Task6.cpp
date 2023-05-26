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
            cout << "�����: �������� ������� ���������\n";
            return;
        }

        Structure newEntry;

        cout << "�������� ��������� ����� ��������(1) ��� ������ � �����(2): ";
        cin >> newEntry.type;

        if (newEntry.type == '1') {
            cout << "������� ��� ������(�� 4� �������� ��� +): ";
            cin >> newEntry.data.variant1.field1;
            cout << "������� ����� "; 
            cin.ignore(); // ������������ ������ ����� ������
            cin.getline(newEntry.data.variant1.field2, sizeof(newEntry.data.variant1.field2));
        }
        else if (newEntry.type == '2') {
            cout << "������� ������ ��������: ";
            cin >> newEntry.data.variant2.field3;
            cout << "������� �����):: ";
            cin >> newEntry.data.variant2.field4;
        }
        else {
            cout << "������: �� ���������� �������\n";
            cin.ignore();
            return;
        }

        database[count++] = newEntry;
        cout << "������ ������� ���������\n";
    }

    void deleteEntry() {
        setlocale(LC_ALL, "");
        if (count == 0) {
            cout << "���� ������ �����\n";
            return;
        }

        int index;
        cout << "������� ����� ������ ��� �������� (�� 1 �� " << count << "): ";
        cin >> index;

        if (index < 1 || index > count) {
            cout << "������: �������� ����� ������\n";
            cin.ignore();
            return;
        }

        for (int i = index - 1; i < count - 1; i++) {
            database[i] = database[i + 1];
        }

        count--;
        cout << "������ ������� �������\n";
    }

    void printEntries() {
        setlocale(LC_ALL, "");
        if (count == 0) {
            cout << "���� ������ �����\n";
            return;
        }

        cout << "���������� ���� ������:\n";
        for (int i = 0; i < count; i++) {
            Structure entry = database[i];

            cout << "������ " << i + 1 << "\n";
            if (entry.type == '1') {
                cout << "������ ���������\n";
                cout << "��� ������: +" << entry.data.variant1.field1 << "\n";
                cout << "�����: " << entry.data.variant1.field2 << "\n";
            }
            else if (entry.type == '2') {
                cout << "������� � ������\n";
                cout << "������: " << entry.data.variant2.field3 << "\n";
                cout << "�����: " << entry.data.variant2.field4 << "\n";
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
        cout << "����:\n";
        cout << "1. �������� ������\n";
        cout << "2. ������� ������\n";
        cout << "3. ������� ��� ��������� ������\n";
        cout << "4. �����\n";
        cout << "������� ���� �������: ";
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
            cout << "�����...\n";
            break;
        default:
            cout << "�� ���������� �������\n";
            break;
        }

        cout << "------------------------\n";
    } while (choice != 4);

    return 0;
}
