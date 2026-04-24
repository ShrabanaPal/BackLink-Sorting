export default function CategorySection({ links, category }) {

  const filtered = links.filter(
    (l) =>
      l.category === category &&
      l.status === "VALID"
  );

  return (
    <div className="grid gap-4">

      {filtered.length === 0 ? (
        <p className="text-gray-400">
          No links found in {category}
        </p>
      ) : (
        filtered.map((l) => (
          <div
            key={l.id}
            className="bg-slate-900 p-5 rounded-xl shadow"
          >

            <h2 className="text-lg font-bold text-white">
              {l.domain}
            </h2>

            <p className="text-green-400">
              {l.status}
            </p>

            <p className="text-gray-400">
              {l.category}
            </p>

            <div className="mt-3 bg-slate-800 p-3 rounded-lg">
              <p className="text-yellow-400 font-semibold">
                Suggestions:
              </p>

              <p className="text-sm text-gray-300 mt-1">
                {l.strategy}
              </p>
            </div>

            <a
              href={l.signInUrl}
              target="_blank"
              rel="noreferrer"
              className="inline-block mt-4 bg-sky-500 text-black px-4 py-2 rounded-lg">
              Login
            </a>

          </div>
        ))
      )}

    </div>
  );
}