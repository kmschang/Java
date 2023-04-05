#!/usr/bin/env bash


# This script is used to format the code using clang-format.

# Exit immediately if a command exits with a non-zero status.
set -e

# Change to the root directory of the project.
cd "$(dirname "$0")/.."

# Format the code.
# shellcheck disable=SC2046
clang-format -i -style=file $(find . -name "*.c" -o -name "*.h")
