
public class Cat implements Comparable<Cat>{
	
	private String name;
	

	public Cat(String name) {
		super();
		this.name = name;
	}
	
	

	@Override
	public String toString() {
		return "Cat [name=" + name + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	// String has a compare to.
	@Override
	public int compareTo(Cat otherCat) {
		// null checks should be done.
		return this.getName().compareTo(otherCat.getName());
	}
	
	
	

}
