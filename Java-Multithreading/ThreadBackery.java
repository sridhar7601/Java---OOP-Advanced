class cake extends Thread{
    public void run(){
        System.out.println("Mixing Ingredient for cake"+cake.currentThread().getId());
        System.out.println("Baking for cake"+cake.currentThread().getId());
        System.out.println("Decorating cake"+cake.currentThread().getId());

    }
}

class Threadackery{
    public static void main(String[] args){

    }
}