public abstract class Npc {
    private String name, type, city;

    public Npc(String name, String type, String city) {
        this.name = name;
        this.type = type;
        this.city = city;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getCity() {
        return city;
    }

    @Override
    public String toString(){
        return "Npc: {" +
                "\nname: " + getName() +
                "\ntype: " + getType() +
                "\ncity: " + getCity();
    }
}
