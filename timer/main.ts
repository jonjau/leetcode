"use strict";

import { runPermutations } from "../tiq2/backtracking/permutations";

function main() {
    console.time("solution");
    runPermutations();
    console.timeEnd("solution");
}

main();
