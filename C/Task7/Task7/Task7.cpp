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

    std::cout << "Запись добавлена в БД.\n";
}

void deleteRecord(int id) {
    setlocale(LC_ALL, "Russian");
    if (head == nullptr) {
        std::cout << "БД пуста.\n";
        return;
    }

    Record* current = head;
    Record* prev = nullptr;

    // Проверка первого элемента списка
    if (current->id == id) {
        head = current->next;
        delete current;
        std::cout << "Запись удалена из БД.\n";
        return;
    }

    // Поиск записи в списке
    while (current != nullptr && current->id != id) {
        prev = current;
        current = current->next;
    }

    // Если запись найдена, удаляем ее
    if (current != nullptr) {
        prev->next = current->next;
        delete current;
        std::cout << "Запись удалена из БД.\n";
    }
    else {
        std::cout << "Запись с указанным идентификатором не найдена.\n";
    }
}

void printRecords() {
    setlocale(LC_ALL, "Russian");
    if (head == nullptr) {
        std::cout << "БД пуста.\n";
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
        std::cout << "Выберите операцию:\n";
        std::cout << "1. Добавить запись\n";
        std::cout << "2. Удалить запись\n";
        std::cout << "3. Вывести все записи\n";
        std::cout << "4. Выйти\n";
        std::cout << "Ваш выбор: ";
        std::cin >> choice;

        switch (choice) {
        case 1:
            std::cout << "Введите идентификатор записи: ";
            std::cin >> id;
            std::cout << "Введите имя записи: ";
            std::cin >> name;
            addRecord(id, name);
            break;
        case 2:
            std::cout << "Введите идентификатор записи для удаления: ";
            std::cin >> id;
            deleteRecord(id);
            break;
        case 3:
            std::cout << "Все записи БД:\n";
            printRecords();
            break;
        case 4:
            return 0;
        default:
            std::cout << "Неверный выбор. Попробуйте снова.\n";
            break;
        }

        std::cout << std::endl;
    }
}