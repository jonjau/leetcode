/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets. Open brackets
 * must be closed in the correct order.
 */
function runIsValid() {
    let res1 = isValid("([)]");
    console.log(res1);
    let res2 = isValid("{[]}");
    console.log(res2);
    
}

/**
 * O(n) time, O(n) space
 * @param s input string
 */
function isValid(s: string): boolean {
    const paren_dict: {[index: string]: string}= {
        ")": "(",
        "]": "[",
        "}": "{"
    };
    const stack: string[] = [];
    for (const paren of s) {
        if (paren in paren_dict) {
            if (stack.pop() !== paren_dict[paren]) {
                return false;
            }
        } else {
            stack.push(paren);
        }
    }
    return stack.length == 0;
};

export { runIsValid }
