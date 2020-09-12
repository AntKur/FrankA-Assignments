public class Calculator implements java.io.Serializable{
    private double operandOne, operandTwo;
    private char operator;
    private double result;

    public Calculator(){

    }

    public Calculator(double operandOne, double operandTwo, char operator){
        this.operandOne = operandOne;
        this.operandTwo = operandTwo;
        this.operator = operator;
    }

    public void setOperandOne(double operandOne){
        this.operandOne = operandOne;
    }

    public void setOperandTwo(double operandTwo){
        this.operandTwo = operandTwo;
    }

    public void setOperation(char operator){
        if(operator == '+'){
            this.operator = operator;
        } else if(operator == '-'){
            this.operator = operator;
        } else{
            System.out.println("Invalid operand: " +operator);
        }
    }

    public void performOperation(){
        if(operator == '+')
            result = operandOne + operandTwo;
        else if(operator == '-')
            result = operandOne - operandTwo; 
        else
            System.out.println("No valid operand set!");       
    }

    public double getResults(){
        return result;
    }
}