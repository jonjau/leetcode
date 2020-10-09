"use strict";

export {}
const s = require("../tiq/math/romanToInteger");

function main() {
    console.time("solution")
    s.runRomanToInt()
    console.timeEnd("solution")
}

main()
