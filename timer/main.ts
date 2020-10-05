"use strict";

export {}
const { runIsValid } = require("../tiq/other/validParentheses");

function main() {
    console.time("solution")
    runIsValid()
    console.timeEnd("solution")
}

main()
