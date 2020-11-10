"use strict";

import { runSubsets } from "../tiq2/backtracking/subsets";

function main() {
    console.time("solution");
    runSubsets();
    console.timeEnd("solution");
}

main();
