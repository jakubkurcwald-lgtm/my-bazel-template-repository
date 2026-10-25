import requests
import unittest


class RequestsDependencyTest(unittest.TestCase):
    def test_dependency_is_available(self) -> None:
        self.assertEqual(requests.__version__, "2.32.3")


if __name__ == "__main__":
    unittest.main()
