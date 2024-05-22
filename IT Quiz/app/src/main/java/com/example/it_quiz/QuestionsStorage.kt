package com.example.it_quiz

object QuestionsStorage {
    val questions = listOf(
        Question(
            question = "№1 Что такое операционная система?",
            answers = listOf(
                "Это просто программа на компьютере, как и другие - Word или Chrome.",
                "Это показатель того, какой процессор используется на компьютере. Например, 32-битный или 64-битный.",
                "Нет такого понятия, есть понятие \"файловая система\".",
                "Это набор взаимосвязанных программ, осуществляющих управление компьютером и взаимодействие с пользователем."
            ),
            points = listOf(0, 0, 0, 1)
        ),
        Question(
            question = "№2 Является ли Android операционной системой?",
            answers = listOf(
                "Да, это такая же ОС, как и другие, просто для мобильных девайсов.",
                "Нет, операционные системы бывают только для ПК.",
                "Нет, Android это программа, которая ставится на операционную систему девайса. ОС на разных девайсах разные.",
                "Это домашняя страничка в настройках вашего браузера."
            ),
            points = listOf(1, 0, 0, 0)
        ),
        Question(
            question = "№3 Что такое процессор компьютера?",
            answers = listOf(
                "Это блок, внутри которого находится дисковод и много разъемов для монитора, клавиатуры и компьютерной мышки.",
                "Это общее название всех комплектующих компьютера.",
                "Это элемент компьютера, с помощью которого обрабатывается информация, находящаяся как в собственной памяти, так и в памяти других устройств.",
                "Это суммарный показатель вычислительной мощности компьютера, например 2,7 ГГц."
            ),
            points = listOf(0, 0, 1, 0)
        ),
        Question(
            question = "№4 Какие бывают разрядности у современных процессоров?",
            answers = listOf(
                "32 и 64 бита",
                "12 и 32 бита",
                "15 и 32 бита",
                "86 и 64 бита"
            ),
            points = listOf(1, 0, 0, 0)
        ),
        Question(
            question = "№5 Для чего компьютеру нужна RAM?",
            answers = listOf(
                "Для быстрого доступа к данным.",
                "Для долгосрочного хранения данных.",
                "Для правильной фрагментации памяти.",
                "Для дефрагментации данных."
            ),
            points = listOf(1, 0, 0, 0)
        ),
        Question(
            question = "№6 Чем отличается HDD от SSD?",
            answers = listOf(
                "HDD - это твердотельный накопитель без подвижных частей. Более дешевый, чем SSD. HDD работает быстрее.",
                "HDD - это твердотельный накопитель без подвижных частей. Более дорогой, чем SSD. HDD работает быстрее.",
                "SSD - это твердотельный накопитель без подвижных частей. Более дешевый, чем HDD. SSD работает быстрее.",
                "SSD - это твердотельный накопитель без подвижных частей. Более дорогой, чем HDD. SSD работает быстрее."
            ),
            points = listOf(0, 0, 0, 1)
        ),
        Question(
            question = "№7 Что такое API?",
            answers = listOf(
                "Это система вывода текста в командную оболочку.",
                "Это ядро операционной системы.",
                "Это программный интерфейс, с его помощью программы общаются друг с другом.",
                "Это интерфейс подключенного к компьютеру принтера."
            ),
            points = listOf(0, 0, 1, 0)
        ),
        Question(
            question = "№8 Является ли bat расширением исполняемого файла в Windows?",
            answers = listOf(
                "Нет, таковым является только exe.",
                "Нет, в Windows не бывает исполняемых файлов.",
                "Да.",
                "Да, но только если это виртуальная машина."
            ),
            points = listOf(0, 0, 1, 0)
        ),
        Question(
            question = "№9 Что такое лог программы?",
            answers = listOf(
                "Файл с инструкцией по ее запуску.",
                "Файл с информацией о ходе ее работы.",
                "Файл с информацией о текущей версии программы.",
                "Файл с информацией об авторе и лицензионных правах на программу."
            ),
            points = listOf(0, 1, 0, 0)
        ), Question(
            question = "№10 Что такое firewall?",
            answers = listOf(
                "Это программа для записи информации на CD-диск.",
                "Это то же самое, что антивирус",
                "Это специальная программа, разрешающая определенным программам взаимодействовать с интернетом только по определенным портам.",
                "Это определенная программа, оценивающая уровень безопасности системы на основе количества неиспользуемых данных."
            ),
            points = listOf(0, 0, 1, 0)
        )
    )
}