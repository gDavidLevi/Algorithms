package ru.davidlevi.lesson6.hw;

/**
 * Дерево
 */
public class Tree {
    private class Node {
        private Cat c; // полезный объект
        Node leftRoot; // хранит ссылку на левый элемент
        Node rightRoot; // хранит ссылку на правый элемент

        Node(Cat c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return String.format("(I:%d, N:%s, A:%d)", c.id, c.name, c.age);
        }
    }
    // -===============================================================================================================-

    private Node root; // корневой узел дерева
    // Для расчета баланса
    private int growthLeft = 0;
    private int growthRight = 0;

    /**
     * Вернуть котика по возрасту
     *
     * @param age int
     * @return Cat
     */
    public Cat find(int age) {
        Node current = root;
        while (current.c.age != age) {
            if (age < current.c.age)
                current = current.leftRoot;
            else
                current = current.rightRoot;
            if (current == null) return null;
        }
        return current.c;
    }

    /**
     * Возвращает минимальный узел в дереве
     *
     * @return Node
     */
    public Node min() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.leftRoot;
        }
        return last;
    }

    /**
     * Добавить котика
     *
     * @param c Cat
     */
    void insert(Cat c) {
        Node node = new Node(c);
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node previous;
            while (true) {
                previous = current;
                if (c.age < current.c.age) {
                    current = current.leftRoot;
                    if (current == null) {
                        previous.leftRoot = node;
                        return;
                    }
                } else {
                    current = current.rightRoot;
                    if (current == null) {
                        previous.rightRoot = node;
                        return;
                    }
                }
            }
        }
    }

    /**
     * Отобразить дерево
     */
     void displayTree() {
        inOrderTravers(root);
    }

    /**
     * Обход: левый корень, правый
     * Симметричный обход.
     *
     * @param current Node от узла
     */
    private void inOrderTravers(Node current) {
        if (current != null) {
            inOrderTravers(current.leftRoot); // сначала влево,...
            System.out.println(current);
            inOrderTravers(current.rightRoot); // ...затем вправо
        }
    }

    /**
     * Удаление узла/листа для удаления
     *
     * @param age int
     * @return boolean
     */
    public boolean delete(int age) {
        Node current = root; // текущий
        Node parent = root; // родитель
        boolean isLeftChild = true;

        // Ищем что именно удалить
        while (current.c.age != age) {
            parent = current;
            if (age < current.c.age) {
                current = current.leftRoot;
                isLeftChild = true;
            } else {
                current = current.rightRoot;
                isLeftChild = false;
            }
            if (current == null) return false;
        }

        // Если узел является листом (левый и правый равны нулю)
        if (current.leftRoot == null && current.rightRoot == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.leftRoot = null;
            else
                parent.rightRoot = null;
        }
        // Если один потомок, то перекидываем ссылки
        else if (current.rightRoot == null) {
            if (isLeftChild)
                parent.leftRoot = current.leftRoot;
            else
                parent.rightRoot = current.leftRoot;
        } else if (current.leftRoot == null) {
            if (isLeftChild)
                parent.leftRoot = current.rightRoot;
            else
                parent.rightRoot = current.rightRoot;
        }
        // Если существуют оба наследника
        else {
            Node inheritor = getInheritor(current);
            if (current == root)
                root = inheritor;
            else if (isLeftChild)
                parent.leftRoot = inheritor;
            else
                parent.rightRoot = inheritor;
            inheritor.leftRoot = current.leftRoot;
            inheritor.rightRoot = current.rightRoot;
        }
        return true;
    }

    /**
     * Возвращает наследника
     *
     * @param node Node
     * @return Node
     */
    private Node getInheritor(Node node) {
        Node current = node.rightRoot;
        Node inheritor = node;
        Node parent = node;
        while (current != null) {
            parent = inheritor;
            inheritor = current;
            current = current.leftRoot;
        }
        if (inheritor != node.rightRoot) {
            parent.leftRoot = inheritor.rightRoot;
        }
        return inheritor;
    }

    /**
     * Сбалансированно ли?
     *
     * @return boolean
     */
    boolean isBalanced() {
        leftGrowth(root);
        rightGrowth(root);
        int result = growthLeft - growthRight;
        growthLeft = 0;
        growthRight = 0;
        if (result <= 1) return true;
        else return false;
    }

    /**
     * @param root Node
     */
    private void leftGrowth(Node root) {
        // Если не корень, то...
        if (root != null) {
            leftGrowth(root.leftRoot);
            growthLeft++; // увеличить вес слева
        }
    }

    /**
     * @param root Node
     */
    private void rightGrowth(Node root) {
        if (root != null) {
            rightGrowth(root.rightRoot);
            growthRight++;
        }
    }
}
