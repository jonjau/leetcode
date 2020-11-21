package main

import (
	"fmt"
	"time"

	s "github.com/jonjau/lc/tiq2/dynamicprogramming"
)

func elapsed(what string) func() {
    start := time.Now()
    return func() {
        fmt.Printf("%s took %v ms\n", what, time.Since(start).Milliseconds())
    }
}

func main() {
    defer elapsed("solution")()
    s.RunCoinChange()
}