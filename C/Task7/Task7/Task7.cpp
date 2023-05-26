#include <iostream>
#include <string>

struct Record {
    int id;
    std::string name;
    Record* next;
};

Record* head = nullptr;

void addRecord(int id, const std::string& name) {
    setlocale(LC_ALL, "Russian");
    Record* newRecord = new Record;
    newRecord->id = id;
    newRecord->name = name;
    newRecord->next = nullptr;

    if (head == nullptr) {
        head = newRecord;
    }
    else {
        Record* current = head;
        while (current->next != nullptr) {
            current = current->next;
        }
        current->next = newRecord;
    }

    std::cout << "������ ��������� � ��.\n";
}

void deleteRecord(int id) {
    setlocale(LC_ALL, "Russian");
    if (head == nullptr) {
        std::cout << "�� �����.\n";
        return;
    }

    Record* current = head;
    Record* prev = nullptr;

    // �������� ������� �������� ������
    if (current->id == id) {
        head = current->next;
        delete current;
        std::cout << "������ ������� �� ��.\n";
        return;
    }

    // ����� ������ � ������
    while (current != nullptr && current->id != id) {
        prev = current;
        current = current->next;
    }

    // ���� ������ �������, ������� ��
    if (current != nullptr) {
        prev->next = current->next;
        delete current;
        std::cout << "������ ������� �� ��.\n";
    }
    else {
        std::cout << "������ � ��������� ��������������� �� �������.\n";
    }
}

void printRecords() {
    setlocale(LC_ALL, "Russian");
    if (head == nullptr) {
        std::cout << "�� �����.\n";
        return;
    }

    Record* current = head;
    while (current != nullptr) {
        std::cout << "ID: " << current->id << ", Name: " << current->name << '\n';
        current = current->next;
    }
}

int main() {
    setlocale(LC_ALL, "Russian");
    int choice;
    int id;
    std::string name;

    while (true) {
        std::cout << "�������� ��������:\n";
        std::cout << "1. �������� ������\n";
        std::cout << "2. ������� ������\n";
        std::cout << "3. ������� ��� ������\n";
        std::cout << "4. �����\n";
        std::cout << "��� �����: ";
        std::cin >> choice;

        switch (choice) {
        case 1:
            std::cout << "������� ������������� ������: ";
            std::cin >> id;
            std::cout << "������� ��� ������: ";
            std::cin >> name;
            addRecord(id, name);
            break;
        case 2:
            std::cout << "������� ������������� ������ ��� ��������: ";
            std::cin >> id;
            deleteRecord(id);
            break;
        case 3:
            std::cout << "��� ������ ��:\n";
            printRecords();
            break;
        case 4:
            return 0;
        default:
            std::cout << "�������� �����. ���������� �����.\n";
            break;
        }

        std::cout << std::endl;
    }
}