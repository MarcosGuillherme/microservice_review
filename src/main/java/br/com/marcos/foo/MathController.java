package br.com.marcos.foo;

import br.com.marcos.exception.EmptyValueException;
import br.com.marcos.exception.NonNumericException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {


    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws NonNumericException{
        if (notIsNumeric(numberOne) || notIsNumeric(numberTwo))
            throw new NonNumericException("Please set a numeric value!");

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String strNumber) {
        String number = validationAndReplace(strNumber);

        return Double.parseDouble(number);
    }

    private String validationAndReplace(String strNumber) {
        if (strNumber.isEmpty()) throw new EmptyValueException("Please type a numer.");

        return strNumber.replaceAll(",", ".");
    }

    private boolean notIsNumeric(String strNumber) {
        String number = validationAndReplace(strNumber);
        return !number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
