package healthcalc;

public interface Person {

    /**
     * @return la altura de la persona
     */
    public float height();
    
    /**
     * @return el peso de la persona
     */
    public float weight();
    
    /**
     * @return la edad de la persona
     */
    public int age();
    
    /**
     * @return el género de la persona
     */
    public Gender gender();
}
