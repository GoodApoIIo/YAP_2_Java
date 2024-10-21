public class City {
    private String name;
    private Connection[] connections;
    private int connectionCount;

    public City(String name) {
        this.name = name;
        this.connections = new Connection[10]; // Начальный размер массива
        this.connectionCount = 0;
    }

    public String getName() {
        return name;
    }

    public void addConnection(City city, int cost) {
        // Проверяем, нужно ли увеличить размер массива
        if (connectionCount == connections.length) {
            // Увеличиваем размер массива в два раза
            Connection[] newConnections = new Connection[connections.length * 2];
            for (int i = 0; i < connectionCount; i++) {
                newConnections[i] = connections[i];
            }
            connections = newConnections;
        }

        // Добавляем новую связь в массив
        connections[connectionCount] = new Connection(city, cost);
        connectionCount++;
    }

    public Connection[] getConnections() {
        Connection[] result = new Connection[connectionCount];
        for (int i = 0; i < connectionCount; i++) {
            result[i] = connections[i];
        }
        return result;
    }

    public String toString() {
        String result = name + ": ";
        for (int i = 0; i < connectionCount; i++) {
            result += connections[i].getCity().getName() + ":" + connections[i].getCost();
            if (i < connectionCount - 1) {
                result += ", ";
            }
        }
        return result;
    }

    // Внутренний класс для представления связи
    private class Connection {
        private City city;
        private int cost;

        public Connection(City city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        public City getCity() {
            return city;
        }

        public int getCost() {
            return cost;
        }
    }
}