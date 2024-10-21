class City_2 {
    private String name;
    private City_2[] paths; // Массив путей к другим городам
    private int pathCount; // Количество добавленных путей
    private int[] costs; // Массив стоимостей для путей

    // Конструктор для создания города только с именем
    public City_2(String name) {
        this.name = name;
        this.paths = new City_2[10]; // Инициализируем массив с начальной емкостью 10
        this.pathCount = 0;
        this.costs = new int[10]; // Инициализируем массив стоимостей
    }

    // Конструктор для создания города с именем и путями
    public City_2(String name, City_2[] paths, int[] costs) {
        this.name = name;
        this.paths = new City_2[paths.length];
        this.pathCount = paths.length;
        this.costs = new int[costs.length]; // Инициализируем массив стоимостей
        for (int i = 0; i < paths.length; i++) {
            this.paths[i] = paths[i];
            this.costs[i] = costs[i];
        }
    }

    public void addPath(City_2 destination, int cost) {
        if (pathCount == paths.length) {
            // Если массив заполнен, увеличиваем его размер
            City_2[] newPaths = new City_2[paths.length * 2];
            int[] newCosts = new int[costs.length * 2]; // Увеличиваем массив стоимостей
            for (int i = 0; i < paths.length; i++) {
                newPaths[i] = paths[i];
                newCosts[i] = costs[i]; // Копируем стоимость
            }
            paths = newPaths;
            costs = newCosts; // Обновляем массив стоимостей
        }
        paths[pathCount] = destination;
        costs[pathCount] = cost;
        pathCount++;
    }

    public String toString() {
        String result = name + ": ";
        for (int i = 0; i < pathCount; i++) {
            result += paths[i].name + ":" + costs[i];
            if (i < pathCount - 1) {
                result += ", ";
            }
        }
        return result;
    }
}