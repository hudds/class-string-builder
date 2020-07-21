# class-string-builder
Um método que monta uma string do objeto com base nos getters públicos. Pode ser útil para sobescrever o método toString.

# Exemplo:
```
class Teste{
	private int param1 = 1;
	private String param2 = "aaa";
	private Double param3 = 3.5;
	
	public int getParam1() {
		return param1;
	}
	
	public String getParam2() {
		return param2;
	}
	
	@Override
	public String toString() {
		return StringBuilderWithReflection.build(this);
	}
}
```

```
public class Test {
	public static void main(String[] args) {
		System.out.println(new Teste());
	}
}
```

### Saída:

```
Teste{param1=1, param2=aaa}
```