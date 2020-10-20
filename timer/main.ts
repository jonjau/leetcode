"use strict";

import { runHammingWeight } from "../tiq/other/numberOf1Bits";

function main() {
    console.time("solution");
    runHammingWeight()
    console.timeEnd("solution");
}

main();
