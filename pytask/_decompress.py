import tarfile
from typing import List

def decompress(filepath: str, outputpath: str = '.', extracts: List[str] | None = None):
    compressed_file = tarfile.open(filepath, 'r')

    if extracts == None:
        return
        compressed_file.extractall()
    else:
        for member in compressed_file.getmembers():
            print(member.path)
            continue
            if member.path in extracts:
                compressed_file
                
    compressed_file.close()


if __name__ == '__main__':
    import argparse

    argparser = argparse.ArgumentParser(add_help=False)

    argparser.add_argument(dest='filepath')
    argparser.add_argument('-o', '--output', dest='output', action="store", default='.')
    argparser.add_argument('-e', '--extractfile', dest='extract', action="store", nargs='*')

    args = argparser.parse_args()

    filepath = args.filepath
    outputpath = args.output
    extracts = args.extract

    decompress(filepath=filepath, outputpath=outputpath, extracts=extracts)

    print(filepath)
    print(outputpath)
    print(extracts)