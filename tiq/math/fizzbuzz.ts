/**
 * Write a program that outputs the string representation of numbers from 1 to
 * n.
 * But for multiples of three it should output “Fizz” instead of the number and
 * for the multiples of five output “Buzz”. For numbers which are multiples of
 * both three and five output “FizzBuzz”.
 */
function runFizzBuzz(): string[] {
    let result = fizzBuzz(100);
    console.log(result);
    return result;
}

/**
 * pseudo golf
 * @param n 
 */
function fizzBuzz(n: number): string[] {
    return Array.from(new Array(n), (_, i: number) => {
        let x = i + 1;
        if (x % 15 == 0) return "FizzBuzz";
        else if (x % 3 == 0) return "Fizz";
        else if (x % 5 == 0) return "Buzz";
        else return x.toString();
    });
}

module.exports = { runFizzBuzz }
