package healthcalc;

public class Usuario implements Person {
    
    private float height;
    private float weight;
    private int age;
    private Gender gender;

    public Usuario(float height, float weight, int age, Gender gender) {
                
        // Altura introducida incorrecta (menor o igual a 0)
        if (height <= 0) {
            throw new IllegalArgumentException("La altura introducida debe ser > 0.");
        }

        // Peso introducido incorrecto (menor o igual a 0)
        if (weight <= 0) {
            throw new IllegalArgumentException("El peso introducido debe ser > 0.");
        }

        // Edad introducida incorrecta (negativa o mayor que 140)
        if (age <= 0) {
            throw new IllegalArgumentException("La edad introducida debe estar entre 0 y 140.");
        }

        // Género introducido incorrecto
        if (!gender.equals(Gender.MALE) && !gender.equals(Gender.FEMALE)){
            throw new IllegalArgumentException("El género introducido no es correcto.");
        
        } else {
            // Altura introducida incorrecta (hombre)
            if (gender.equals(Gender.MALE) && height > 250) {
                throw new IllegalArgumentException("La altura introducida es incorrecta para un hombre.");
            }

            // Altura introducida incorrecta (mujer)
            if (gender.equals(Gender.FEMALE) && height > 230) {
                throw new IllegalArgumentException("La altura introducida es incorrecta para una mujer.");
            }
        }

        this.height = height;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public float height() {
        return this.height;
    }

    @Override
    public float weight() {
        return this.weight;
    }

    @Override
    public int age() {
        return this.age;
    }

    @Override
    public Gender gender() {
        return this.gender;
    }
    
}
