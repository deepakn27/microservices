package builderpattern;

class EmployeeN{
	
	//address details
	public String streetAddress,City;
	
	//job details
	public String workLocation,post;
	public int annualIncome;
	@Override
	public String toString() {
		return "EmployeeN [streetAddress=" + streetAddress + ", City=" + City + ", workLocation=" + workLocation
				+ ", post=" + post + ", annualIncome=" + annualIncome + "]";
	}
		
}

class EmployeeBuilder{
	
	protected EmployeeN employee = new EmployeeN();
	public EmployeeJobBuilder works()
	{
		return new EmployeeJobBuilder(employee);
	}
	
	public EmployeeAddressBuilder lives()
	{
		return new EmployeeAddressBuilder(employee);
	}
	
	public EmployeeN build()
	{
		return employee;
	}
}
class EmployeeJobBuilder extends EmployeeBuilder
{
	public EmployeeJobBuilder(EmployeeN employee)
	{
		this.employee=employee;
	}
	
	public EmployeeJobBuilder worksAt(String workLocation)
	{
		employee.workLocation = workLocation;
		return this;
	}
	
	public EmployeeJobBuilder atPost(String post)
	{
		employee.post = post;
		return this;
	}
	
	public EmployeeJobBuilder withIncome(Integer income)
	{
		employee.annualIncome = income;
		return this;
	}
}
class EmployeeAddressBuilder extends EmployeeBuilder
{
	public EmployeeAddressBuilder(EmployeeN employee)
	{
		this.employee=employee;
	}
	
	public EmployeeAddressBuilder livesAt(String streetAddress)
	{
		employee.streetAddress=streetAddress;
		return this;
	}
	
	public EmployeeAddressBuilder in(String city)
	{
		employee.City=city;
		return this;
	}
}
public class MultipleBuilderDemo {

	public static void main(String[] args) {
		EmployeeBuilder eb= new EmployeeBuilder();
		EmployeeN e = eb.lives()
						.livesAt("House No.-118")
						.in("delhi")
					 .works()
					 	.worksAt("Noida")
					 	.atPost("SE")
					 	.withIncome(100).build();
								
		System.out.println(e);
	}
}
