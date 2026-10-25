# Bazel JVM and Python template

A small, reusable Bzlmod workspace with working examples of Scala, Java/Maven,
and Python dependency management. Bazel and all language dependencies are
declared centrally and resolved hermetically.

## Requirements

- Bazelisk (the Ansible installer is in `ansible/install_bazel.yml`)
- A network connection for the first build, to download Bazel toolchains and
  dependencies

## Install Bazel

Install Bazelisk as `~/.local/bin/bazel` on the local Linux machine
(x86_64 or aarch64):

```sh
ansible-playbook -i localhost, -c local ansible/install_bazel.yml
```

Bazelisk reads `.bazelversion` and downloads the pinned Bazel release
automatically when you first run a Bazel command in this repository. Ensure
`~/.local/bin` is on your `PATH`; if not, add
`export PATH="$HOME/.local/bin:$PATH"` to your shell profile.

## Build and run

```sh
bazel build //...
bazel run //scala:hello
bazel run //jvm:hello
bazel run //python:hello
```

Run all sample tests with `bazel test //...`. Each language package includes a
small test target.

## Dependency layout

- **Scala:** `MODULE.bazel` selects Scala 2.13 and configures the rules_scala
  toolchain. The Scala library uses Apache Commons Lang and Guava from Maven.
- **Java/JVM:** `rules_jvm_external` resolves Maven artifacts declared in
  `MODULE.bazel`; the Java example uses Guava and Apache Commons Lang. A
  generated `maven_install.json` pins Maven artifacts and checksums.
- **Python:** `rules_python` configures a hermetic Python 3.12 toolchain.
  `requirements.txt` declares the PyPI dependency tree, resolved by the
  `pip.parse` module extension.

When changing Maven coordinates, update the pin file with:

```sh
REPIN=1 bazel run @maven//:pin
```

Keep `MODULE.bazel.lock` checked in as well; Bazel updates it when module
dependencies change.
