"use strict";

export {}
const { run } = require("../tiq/math/fizzbuzz");

function main() {
    console.time("solution")
    run()
    console.timeEnd("solution")
}

main()
